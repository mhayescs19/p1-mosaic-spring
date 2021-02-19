
/*
 * Copyright (c) 2021. Made by Andrew Pegg
 * free to use just dont brand my code as yours
 * Hope this service helps you :)
 */

package Tools.DynamoDb;

import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.*;
import java.util.stream.Collectors;

public class itemToHashMap {
    public Map<String,Object> convertItemToMap(EnhancedAttributeValue item) //Enhanced Item is used Because It Can be Casted to one Using EnhancedAttributeValue.fromMap() which is the return from dynamodb
    {
        HashMap<String,Object> finalHashmap = new HashMap<>();
        EnhancedAttributeValue value;
        for(String key:item.asMap().keySet())
        {
            value = EnhancedAttributeValue.fromAttributeValue(item.asMap().get(key));
            switch (value.type())
            {
                case NULL -> finalHashmap.put(key,null);
                case BOOL -> finalHashmap.put(key,value.asBoolean());
                case N -> finalHashmap.put(key,value.asNumber());
                case S -> finalHashmap.put(key,value.asString());
                case L -> finalHashmap.put(key,listConverter(value));
                case M -> finalHashmap.put(key,mapConverter(value));
                case SS -> finalHashmap.put(key,value.asSetOfStrings());
                case NS -> finalHashmap.put(key,value.asSetOfNumbers().stream().map(Double::parseDouble).collect(Collectors.toList()));
                default -> System.out.println("unknown data type");
            }
        }
        return finalHashmap.size()>0? finalHashmap : null;
    }
    //possibly going to be recursive because the fact this is going to parse json
    // no binary sets because idk dont feel like looking them up tbh
    private List<Object> listConverter(EnhancedAttributeValue passedValue)
    {
        LinkedList<Object> tempLink = new LinkedList<>(); // o(1) addition good for adding to a list will convert to array list at the end
        for (AttributeValue value: passedValue.asListOfAttributeValues()) {
            EnhancedAttributeValue enhancedAttributeValue = EnhancedAttributeValue.fromAttributeValue(value);
            switch (enhancedAttributeValue.type())
            {
                case S -> tempLink.add(enhancedAttributeValue.asString());
                case BOOL -> tempLink.add(enhancedAttributeValue.asBoolean());
                case N -> tempLink.add(Double.parseDouble(enhancedAttributeValue.asNumber()));
                case NULL -> tempLink.add(null);
                case SS -> tempLink.add(enhancedAttributeValue.asSetOfStrings());
                case NS -> tempLink.add(enhancedAttributeValue.asSetOfNumbers().stream().map(Double::parseDouble).collect(Collectors.toList()));
                case L -> tempLink.add(listConverter(enhancedAttributeValue));
                case M -> tempLink.add(mapConverter(enhancedAttributeValue));

            }
        }
        return (tempLink.size() > 0) ? new ArrayList<>(tempLink) : Collections.singletonList("empty");
    }

    private Map<String,Object> mapConverter(EnhancedAttributeValue valueMap)
    {
        HashMap<String,Object> finalMap = new HashMap<>();
        for (String key : valueMap.asMap().keySet())
        {
            AttributeValue temp = valueMap.asMap().get(key);
            EnhancedAttributeValue enhancedAttributeValue;
            enhancedAttributeValue = EnhancedAttributeValue.fromAttributeValue(temp);
            switch (enhancedAttributeValue.type())
            {
                case S -> finalMap.put(key,enhancedAttributeValue.asString());
                case BOOL -> finalMap.put(key,enhancedAttributeValue.asBoolean());
                case N -> finalMap.put(key,Double.parseDouble(enhancedAttributeValue.asNumber()));
                case NULL -> finalMap.put(key,null);
                case SS -> finalMap.put(key,enhancedAttributeValue.asSetOfStrings());
                case NS -> finalMap.put(key,enhancedAttributeValue.asSetOfNumbers().stream().map(Double::parseDouble).collect(Collectors.toList()));
                case L -> finalMap.put(key,listConverter(enhancedAttributeValue));
                case M -> finalMap.put(key,mapConverter(enhancedAttributeValue));
            }
        }
        return finalMap;
    }

}
