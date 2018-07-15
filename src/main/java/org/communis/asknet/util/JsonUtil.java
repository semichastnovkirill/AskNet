package org.communis.asknet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class JsonUtil {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    public static byte[] toBytesJson(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(value);
    }

    public static String toStringJson(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    public static <T> T parseJson(String json, Class<T> valueType) throws IOException {
        return objectMapper.readValue(json, valueType);
    }

    public static <T extends Collection, V> T parseJsonCollection(String json, Class<T> collectionClass, Class<V> valueType) throws IOException {
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        return objectMapper.readValue(json, typeFactory.constructCollectionType(collectionClass, valueType));
    }

    public static <T extends Map, K, V> T parseJsonMap(String json, Class<T> mapClass, Class<K> keyType, Class<V> valueType) throws IOException {
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        return objectMapper.readValue(json, typeFactory.constructMapType(mapClass, keyType, valueType));
    }
}
