package org.freeabyss.json;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class JsonLexTest {

    @Test
    void nextToken() {
        String json = "{\"name\":\"freeabyss\",\"age\":18}";

        List<Token> tokens = parseTokenList(json);
        Assertions.assertIterableEquals(tokens, List.of(
                new Token(TokenTypeEnum.BEGIN_OBJECT),
                new Token(TokenTypeEnum.STRING, "name"),
                new Token(TokenTypeEnum.SEP_COLON),
                new Token(TokenTypeEnum.STRING, "freeabyss"),
                new Token(TokenTypeEnum.SEP_COMMA),
                new Token(TokenTypeEnum.STRING, "age"),
                new Token(TokenTypeEnum.SEP_COLON),
                new Token(TokenTypeEnum.NUMBER, 18),
                new Token(TokenTypeEnum.END_OBJECT),
                new Token(TokenTypeEnum.EOF)
        ), "token 不匹配");
    }

    private List<Token> parseTokenList(String json) {
        List<Token> tokens = new ArrayList<>();

        JsonLex jsonLex = new JsonLex(new CharReader(json));
        while (true) {
            Token token = jsonLex.nextToken();
            tokens.add(token);
            if (token.getType() == TokenTypeEnum.EOF) {
                break;
            }
        }
        return tokens;
    }
}