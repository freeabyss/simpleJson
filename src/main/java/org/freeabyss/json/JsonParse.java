package org.freeabyss.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class JsonParse {


    public void parse(String str) {
        JsonLex lex = new JsonLex(str);
        Token token = null;
        Stack stack = new Stack();
        while ((token = lex.nextToken()).getType() != TokenTypeEnum.EOF) {

            switch (token.getType()) {
                case BEGIN_OBJECT:
                    stack.push(new HashMap<>());
                    break;
                case END_OBJECT:
                    stack.pop();
                    break;
                case BEGIN_ARRAY:
                    stack.push(new ArrayList<>());
                    break;
                case END_ARRAY:
                    stack.pop();
                    break;
                case STRING:
                    break;
                case NUMBER:
                    break;
                case BOOLEAN:
                    break;
                case NULL:
                    break;
                case SEP_COLON:
                    break;
                case SEP_COMMA:
                    break;
                default:
                    break;
            }

        }
    }
}
