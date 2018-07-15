package org.communis.asknet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;


public class XmlUtil {
    private static final XmlMapper xmlMapper;

    static {
        xmlMapper = new XmlMapper();
    }

    public static byte[] toBytesXml(Object value) throws JsonProcessingException {
        return xmlMapper.writeValueAsBytes(value);
    }

    public static String toStringXml(Object value) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(value);
    }

    public static <T> T parseXml(String xml, Class<T> valueType) throws IOException {
        return xmlMapper.readValue(xml, valueType);
    }

    public static <T extends Collection, V> T parseJsonCollection(String json, Class<T> collectionClass, Class<V> valueType) throws IOException {
        TypeFactory typeFactory = xmlMapper.getTypeFactory();
        return xmlMapper.readValue(json, typeFactory.constructCollectionType(collectionClass, valueType));
    }

    public static <T extends Map, K, V> T parseJsonMap(String json, Class<T> mapClass, Class<K> keyType, Class<V> valueType) throws IOException {
        TypeFactory typeFactory = xmlMapper.getTypeFactory();
        return xmlMapper.readValue(json, typeFactory.constructMapType(mapClass, keyType, valueType));
    }
}
