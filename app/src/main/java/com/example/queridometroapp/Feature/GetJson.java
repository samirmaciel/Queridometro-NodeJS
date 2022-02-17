package com.example.queridometroapp.Feature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetJson {

    public static Map<String, Array> getMap(String s) throws JsonProcessingException {
        return new ObjectMapper().readValue(s, HashMap.class);
    }

    public static List<Integer> getArray(String s) throws JsonProcessingException {
        return new ObjectMapper().readValue(s, List.class);
    }
}
