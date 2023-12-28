package psl.np.common.utils;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class MapperUtils {

    private static ObjectMapper mapper;

    private static ObjectMapper getMapper() {
        if (mapper == null) {
            synchronized (MapperUtils.class) {
                if (mapper == null) {
                    mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    mapper.enable(Feature.ALLOW_NUMERIC_LEADING_ZEROS);
                }
            }
        }
        return mapper;
    }

    public static <T> String toJson(T obj) throws JsonProcessingException {
        return getMapper().writeValueAsString(obj);
    }

    public static <T> void writeValue(PrintWriter writer, T obj) throws IOException {
        getMapper().writeValue(writer, obj);
    }

    public static <T> T toObject(String json, Class<T> tClass) throws IOException {
        return getMapper().readValue(json, tClass);
    }

    public static JsonNode readTree(String json) throws IOException {
        return getMapper().readTree(json);
    }

    public static JsonNode convertFromMap(Map map) {
        return getMapper().valueToTree(map);
    }

    public static String safeParseNode(JsonNode node) {
        if (node == null) {
            return null;
        }
        try {
            return MapperUtils.toJson(node);
        } catch (JsonProcessingException e) {
            return node.toString();
        }
    }
}
