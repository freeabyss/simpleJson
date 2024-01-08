package org.freeabyss.json;

public interface JsonObject {


    Integer getInteger(String key);


    String getString(String key);

    Double getDouble(String key);

    Boolean getBoolean(String key);


    JsonObject getJsonObject(String key);

    JsonArray getJsonArray(String key);

    Object get(String key);

    boolean containsKey(String key);

    boolean isEmpty();

    int size();

}
