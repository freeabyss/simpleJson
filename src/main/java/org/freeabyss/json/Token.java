package org.freeabyss.json;

import java.util.Objects;

public class Token {

    private TokenTypeEnum type;
    private Object value;

    public Token(TokenTypeEnum type) {
        this.type = type;
    }

    public Token(TokenTypeEnum type, Object value) {
        this.type = type;
        this.value = value;
    }

    public TokenTypeEnum getType() {
        return type;
    }

    public void setType(TokenTypeEnum type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Token) {
            Token token = (Token) obj;
            return token.getType() == this.getType() && Objects.equals(token.getValue(), this.getValue());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
