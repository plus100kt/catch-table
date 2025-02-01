package com.echo.catchtable.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class JsonHelper extends ObjectMapper {
    private static final JsonHelper instance = new JsonHelper();
    public static  JsonHelper getInstance() {
        return instance;
    }
    ObjectMapper objectMapper = new ObjectMapper();

    public String jsonArrayToString(Object[] jsonList) {
        return Arrays.stream(jsonList).map(weekInfo -> {
            try {
                return objectMapper.writeValueAsString(weekInfo);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).toList().toString();
    }
}
