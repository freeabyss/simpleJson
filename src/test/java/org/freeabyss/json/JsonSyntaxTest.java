package org.freeabyss.json;

import org.junit.jupiter.api.Test;

class JsonSyntaxTest {

    @Test
    void parse_01() {
        String json = "{\"name\":\"freeabyss\",\"age\":18}";
        JsonSyntax jsonSyntax = new JsonSyntax(new JsonLex(new CharReader(json)));
        System.out.println(jsonSyntax.parse());
    }

    // 测试 json 数组
    @Test
    void parse_02() {
        String json = "[{\"name\":\"freeabyss\",\"age\":18.5},{\"name\":\"freeabyss\",\"age\":1.8 }]";
        JsonSyntax jsonSyntax = new JsonSyntax(new JsonLex(new CharReader(json)));
        System.out.println(jsonSyntax.parse());
    }
}