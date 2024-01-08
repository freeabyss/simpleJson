package org.freeabyss.json;

import java.util.List;

public class Json {

    public <T> T parseObject(String json, Class<T> clazz) {
        return null;
    }

    public <T> T parseArray(String json, Class<T> clazz) {
        return null;
    }

    public DefaultJsonObject parseJsonObject(String json) {
        return new JsonSyntax(new JsonLex(new CharReader(json))).parseObject();
    }

    public List parseList(String json) {
        return new JsonSyntax(new JsonLex(new CharReader(json))).parseArray();
    }
}
