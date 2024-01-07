package org.freeabyss.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonSyntax {


    private final JsonLex jsonLex;

    public JsonSyntax(JsonLex jsonLex) {
        this.jsonLex = jsonLex;
    }

    public Object parse() {
        Token token = jsonLex.nextToken();
        switch (token.getType()) {
            case BEGIN_OBJECT:
                return parseObject();
            case BEGIN_ARRAY:
                return parseArray();
            case EOF:
                return null;
            default:
                throw new RuntimeException("Unexpected token: " + token);
        }

    }

    public Map parseObject() {
        Token token;
        Map result = new HashMap();
        while (true) {
            token = jsonLex.nextToken();
            switch (token.getType()) {
                case END_OBJECT,EOF:
                    return result;
                case STRING:
                    String key = (String) token.getValue();
                    token = jsonLex.nextToken();
                    if (token.getType() != TokenTypeEnum.SEP_COLON) {
                        throw new RuntimeException("Expected : but " + token);
                    }
                    result.put(key, getValue());
                    continue;
                case SEP_COMMA:
                    continue;

                default:
                    throw new RuntimeException("Unexpected token: " + token);

            }
        }
    }

    public List parseArray() {
        Token token;
        List result = new ArrayList();
        while (true) {
            token = jsonLex.nextToken();

            switch (token.getType()) {
                case END_ARRAY:
                    return result;
                case BEGIN_OBJECT:
                    result.add(parseObject());
                    continue;
                case BEGIN_ARRAY:
                    result.add(parseArray());
                    continue;
                case STRING, NUMBER, BOOLEAN, NULL:
                    result.add(token.getValue());
                    continue;
                case SEP_COMMA:
                    continue;
                default:
                    throw new RuntimeException("Unexpected token: " + token);
            }
        }
    }

    private Object getValue() {
        Token token = jsonLex.nextToken();
        switch (token.getType()) {
            case STRING, NUMBER, BOOLEAN, NULL:
                return token.getValue();
            case BEGIN_OBJECT:
                return parseObject();
            case BEGIN_ARRAY:
                return parseArray();
            default:
                throw new RuntimeException("Unexpected token: " + token);
        }
    }
}
