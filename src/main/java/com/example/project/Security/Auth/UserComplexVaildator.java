package com.example.project.Security.Auth;

import com.example.project.NewUser.NewUser;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository("UserValidator")
public class UserComplexVaildator implements Validator {

    private static final List<Character> specialChars = Lists.newArrayList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '~', '/', '[', ']');

    @Override
    public boolean supports(Class<?> aClass) {
        return NewUser.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewUser user = (NewUser) target;
        if (!CheckUsernameIsNumber(user.getUsername())) {
            errors.rejectValue("username", "UserForm.Username.Numbers.username");
        }
        if (!isSecurePassword(user.getPassword())) {
            errors.rejectValue("password", "UserForm.Complexity.password");
        }
        if (!usernameIsUnique(user.getUsername()))
        {
            errors.rejectValue("username","UserForm.UserName.Unique.username");
        }


    }

    private boolean CheckUsernameIsNumber(String string) {
        char[] chars = string.toCharArray();
        for (char character : chars) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSecurePassword(String password) {
        boolean containsDigit = false;
        boolean containsSpecialCharcter = false;
        for (char charcter : password.toCharArray()) {
            if ((int) charcter >= 48 && (int) charcter <= 57) {
                containsDigit = true;
                break;
            }
        }
        for (char chars : password.toCharArray()) {
            if (specialChars.contains(chars)) {
                containsSpecialCharcter = true;
                break;
            }
        }
        return containsDigit && containsSpecialCharcter;

    }
    private boolean usernameIsUnique(String username)
    {
        DynamoDbClient dbClient = DynamoDbClient.create();
        Map<String, AttributeValue> key = new HashMap<>();
        key.put(":valid", AttributeValue.builder().s(username).build());
        QueryRequest request = QueryRequest.builder().tableName("Students").keyConditionExpression("IDNumber = :valid").expressionAttributeValues(key).select("COUNT").build();
        try{
            int count = dbClient.query(request).count();
            return count <= 0;
        }
        catch (DynamoDbException e)
        {
            System.err.println(e.getMessage());
            return false;
        }

    }

}



