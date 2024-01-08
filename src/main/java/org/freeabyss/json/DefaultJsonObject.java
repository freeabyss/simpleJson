package org.freeabyss.json;

import java.util.Collections;
import java.util.Map;

public class DefaultJsonObject implements JsonObject {

    private final Map<String, Object> map;

    public DefaultJsonObject(Map<String, Object> map) {
        if (map == null) {
            this.map = Collections.emptyMap();
        } else {

            this.map = map;
        }
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return map != null && map.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return map == null || map.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Integer getInteger(String key) {
        Object value = map.get(key);

        if (value == null) {
            return null;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        throw new RuntimeException("Can not cast to int, value : " + value);
    }

    @Override
    public String getString(String key) {
        Object value = map.get(key);

        if (value == null) {
            return null;
        }
        return value.toString();
    }

    @Override
    public Double getDouble(String key) {
        Object value = map.get(key);

        if (value == null) {
            return null;
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        if (value instanceof String) {
            return Double.parseDouble((String) value);
        }
        throw new RuntimeException("Can not cast to double, value : " + value);
    }

    @Override
    public Boolean getBoolean(String key) {
        Object value = map.get(key);

        if (value == null) {
            return null;
        }
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        throw new RuntimeException("Can not cast to double, value : " + value);
    }

    @Override
    public JsonObject getJsonObject(String key) {
        Object value = map.get(key);
        if (value instanceof Map) {
            return new DefaultJsonObject((Map<String, Object>) value);
        }
        if (value instanceof JsonObject) {
            return (JsonObject) value;
        }
        throw new RuntimeException("Can not cast to JsonObject, value : " + value);
    }

    @Override
    public JsonArray getJsonArray(String key) {
        Object value = map.get(key);

        return null;
    }


}
