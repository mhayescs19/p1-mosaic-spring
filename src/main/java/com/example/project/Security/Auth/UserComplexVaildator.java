package com.example.project.Security.Auth;

import com.example.project.NewUser.NewUser;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
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
            errors.rejectValue("username", "username must be all numbers");
        }
        if (!isSecurePassword(user.getPassword())) {
            errors.rejectValue("password", "password must contain at least one digit and one special character");
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
    private boolean usernameIsUinque(String username)
    {
        DynamoDbClient dbClient = DynamoDbClient.create();
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("IDNumber", AttributeValue.builder().s(username).build());
        QueryRequest request = QueryRequest.builder().tableName("Students").build();
        //@todo add query
        return true;
    }

}



