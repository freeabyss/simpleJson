package org.freeabyss.json;

import static org.junit.jupiter.api.Assertions.*;

class JsonParseTest {

    @org.junit.jupiter.api.Test
    void parse() {

        JsonParse parse = new JsonParse();
        parse.parse("{\"name\":\"freeabyss\",\"age\":18,\"sex\":true,\"score\":99.5,\"hobby\":[\"basketball\",\"football\"]}");

    }
}