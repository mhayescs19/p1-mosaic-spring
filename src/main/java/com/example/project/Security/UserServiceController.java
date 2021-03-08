package com.example.project.Security;

import Tools.DynamoDb.hashMapToItem;
import com.example.project.NewUser.ListOfClasses;
import com.example.project.NewUser.NewUser;
import com.example.project.NewUser.RandomCreateClassData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import synergy.Class;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller for login and logout
 * @see SecurityConfig
 * @see com.example.project.Security.Auth.UserService
 * @author Andrew
 */
@Controller
public class UserServiceController {
    @Autowired
    @Qualifier("UserValidator")
    private Validator validator;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    @Qualifier("ClassListData")
    ListOfClasses listOfClasses;
    @Autowired
    @Qualifier("CreateClassData")
    RandomCreateClassData classData;
    @GetMapping("/login")
    public String getLoginView()
    {
        return "synergy/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "synergy/logout";
    }
    @GetMapping("/createUser")
    public String createUser(Model model)
    {
        model.addAttribute("newUser", new NewUser());
        return "synergy/CreateUser";
    }
    @PostMapping("/createUser")
    public String createUser(@Valid NewUser user, BindingResult bindingResult) throws JsonProcessingException {

        if (bindingResult.hasErrors())
        {
            return "synergy/CreateUser";
        }
        validator.validate(user,bindingResult);
        if (bindingResult.hasErrors())
        {
            return "synergy/CreateUser";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        List<Class> classList = classData.createClassesData();
        String json = new ObjectMapper().writeValueAsString(classList);
        List classes = new ObjectMapper().readValue(json,List.class);
        Map<String,Object> finalMap = user.toMap();
        finalMap.put("Classes",classes);
        HashMap<String,Object> objectHashMap = new HashMap<>(finalMap);
        Map<String, AttributeValue> attributeValueMap = new hashMapToItem().hashMapToValue(objectHashMap);
        DynamoDbClient dbClient = DynamoDbClient.create();
        PutItemRequest putItemRequest = PutItemRequest.builder().item(attributeValueMap).tableName("Students").conditionExpression("attribute_not_exists(IDNumber)").build();
        try{
            dbClient.putItem(putItemRequest);

        }catch (DynamoDbException e)
        {
            System.out.println(e.getMessage());
            return "synergy/CreateUser";
        }

        return "synergy/successful";




    }


}
