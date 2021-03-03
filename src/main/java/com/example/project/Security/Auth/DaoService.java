package com.example.project.Security.Auth;

import Tools.DynamoDb.itemToHashMap;
import com.example.project.Security.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository("DynamoDb")
public class DaoService implements UserDao{


    @Override
    public Optional<User> selectUserByUsername(String username) {

        User user = getUserFromDatabase(username);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    private User getUserFromDatabase(String username)
    {
        DynamoDbClient dynamoDbClient = DynamoDbClient.create();
        Map<String,Object> result;
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("IDNumber", AttributeValue.builder().s(username).build());
        Map<String,String> expressionNames = new HashMap<>();
        expressionNames.put("#r","Role"); //: = val while #Name
        GetItemRequest getItemRequest = GetItemRequest.builder().tableName("Students").key(key).projectionExpression("Password,#r").expressionAttributeNames(expressionNames).build();
        try{
            result = new itemToHashMap().convertItemToMap(EnhancedAttributeValue.fromMap(dynamoDbClient.getItem(getItemRequest).item()));
            if (result.isEmpty())
            {
                return null;
            }
        }
        catch (DynamoDbException e)
        {
            return null;
        }
        String roleenum = result.get("Role").toString();
        UserRoles userRoles = null;
        for (UserRoles roles : UserRoles.values())
        {
            if (roleenum.equals(roles.name()))
            {
                userRoles = roles;

            }
        }
        if (userRoles == null) {
            return null;
        }
        return new User(username,result.get("Password").toString(),userRoles.getGrantedAuthority()
                ,true,true , true , true);
    }

}
