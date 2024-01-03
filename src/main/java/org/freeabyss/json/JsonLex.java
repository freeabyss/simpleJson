package org.freeabyss.json;

/**
 * 词法解析
 */
public class JsonLex {

    private final String text;
    private int pos = 0;

    public JsonLex(String text) {
        this.text = text;
    }

    public Token nextToken() {
        char c = next();
        return switch (c) {
            case '{' -> new Token(TokenTypeEnum.BEGIN_OBJECT);
            case '}' -> new Token(TokenTypeEnum.END_OBJECT);
            case '[' -> new Token(TokenTypeEnum.BEGIN_ARRAY);
            case ']' -> new Token(TokenTypeEnum.END_ARRAY);
            case ',' -> new Token(TokenTypeEnum.SEP_COMMA);
            case ':' -> new Token(TokenTypeEnum.SEP_COLON);
            case 'n' -> readNull();
            case 't' -> readTrue();
            case 'f' -> readFalse();
            case '"' -> readString();
            default -> {
                if (c == '-' || (c >= '0' && c <= '9')) {
                    yield readNumber();
                }
                yield new Token(TokenTypeEnum.EOF);
            }
        };

    }

    private Token readNumber() {
        char c = next();
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        while (true) {
            c = next();
            if (c == '.') {
            } else if (c == 'e' || c == 'E') {
                sb.append(c);
                c = next();
                if (c == '+' || c == '-') {
                    sb.append(c);
                    c = next();
                }
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
        }
        return new Token(TokenTypeEnum.NUMBER, sb.toString());
    }

    /**
     * 读取字符串
     */
    private Token readString() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char c = next();
            switch (c) {
                case '"':
                    return new Token(TokenTypeEnum.STRING, sb.toString());
                case '\\':
                    char next = next();
                    switch (next) {
                        case '"':
                            sb.append('"');
                            break;
                        case '\\':
                            sb.append('\\');
                            break;
                        case '/':
                            sb.append('/');
                            break;
                        case 'b':
                            sb.append('\b');
                            break;
                        case 'f':
                            sb.append('\f');
                            break;
                        case 'n':
                            sb.append('\n');
                            break;
                        case 'r':
                            sb.append('\r');
                            break;
                        case 't':
                            sb.append('\t');
                            break;
                        case 'u':
                            char[] chars = new char[4];
                            chars[0] = next();
                            chars[1] = next();
                            chars[2] = next();
                            chars[3] = next();
                            sb.append((char) Integer.parseInt(new String(chars), 16));
                            break;
                        default:
                            throw new RuntimeException("invalid json");
                    }
                    break;
                default:
                    sb.append(c);
            }
        }
    }

    private Token readFalse() {
        if (next() == 'a' && next() == 'l' && next() == 's' && next() == 'e') {
            return new Token(TokenTypeEnum.BOOLEAN, "false");
        }
        throw new RuntimeException("invalid json");
    }

    private Token readTrue() {
        if (next() == 'r' && next() == 'u' && next() == 'e') {
            return new Token(TokenTypeEnum.BOOLEAN, "true");
        }
        throw new RuntimeException("invalid json");
    }

    private Token readNull() {
        if (next() == 'u' && next() == 'l' && next() == 'l') {
            return new Token(TokenTypeEnum.NULL);
        }
        throw new RuntimeException("invalid json");
    }

    private char next() {
        if (pos >= text.length()) {
            return 0;
        }
        return text.charAt(pos++);
    }
}
