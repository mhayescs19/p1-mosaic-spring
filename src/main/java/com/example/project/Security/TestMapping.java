package com.example.project.Security;

import Tools.DynamoDb.itemToHashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import synergy.Assignment;
import synergy.Class;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/testing")
@PreAuthorize("hasAnyRole('ROLE_TEACHER')")
public class TestMapping {

    @GetMapping("/databind")
    @ResponseBody
    public String doDatabind() throws Exception {
        DynamoDbClient dbClient = DynamoDbClient.create();
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("IDNumber", AttributeValue.builder().s("12").build());
        GetItemRequest request = GetItemRequest.builder().tableName("Students").key(key).projectionExpression("Classes").build();
        System.out.println("Staring the Request to get user under id 12");
        try{
            Map<String,AttributeValue> returneditems = dbClient.getItem(request).item();
            Map<String,Object> convertedOver = new itemToHashMap().convertItemToMap(EnhancedAttributeValue.fromMap(returneditems));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Object> classes = (List<Object>) convertedOver.get("Classes");
            List<Class> classList = new LinkedList<>();
            for (Object obj:classes) {
                String json = objectMapper.writeValueAsString(obj);
                classList.add(objectMapper.readValue(json,Class.class));
            }
            return "made it out of the loop";

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            throw new Exception("Something went wrong " + e.getMessage());
        }


    }
    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody List<Assignment> list) throws JsonProcessingException {
        System.out.println(list);
        return new ObjectMapper().writeValueAsString(list);
    }
    @GetMapping("/update")
    public String updater()
    {
        return "update";
    }



}
