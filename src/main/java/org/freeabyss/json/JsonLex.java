package org.freeabyss.json;

/**
 * 词法解析
 */
public class JsonLex {

    private final CharReader reader;

    public JsonLex(CharReader reader) {
        this.reader = reader;
    }

    public Token nextToken() {
        if (!reader.hasNext()) {
            return new Token(TokenTypeEnum.EOF);
        }
        char c = reader.next();
        // 跳过空白字符
        while (Character.isWhitespace(c)) {
            c = reader.next();
        }
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
                    reader.back();
                    yield readNumber();
                }
                yield new Token(TokenTypeEnum.EOF);
            }
        };

    }

    /**
     * 读取一个数字
     *
     * @return
     */
    private Token readNumber() {
        char c = reader.next();
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        boolean isDouble = false;
        while (true) {
            c = reader.next();
            if (c == '.') {
                isDouble = true;
                sb.append(c);
            } else if (c == 'e' || c == 'E') {
                sb.append(c);
                c = reader.next();
                if (c == '+' || c == '-') {
                    sb.append(c);
                }
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            } else if (c == '}' || c == ']' || c == ',') {
                reader.back();
                break;
            } else {
                break;
            }
        }
        Object value;
        if (isDouble) {
            value = Double.valueOf(sb.toString());
        } else {
            value = Integer.valueOf(sb.toString());
        }
        return new Token(TokenTypeEnum.NUMBER, value);
    }

    /**
     * 读取字符串
     */
    private Token readString() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char c = reader.next();
            switch (c) {
                case '"':
                    return new Token(TokenTypeEnum.STRING, sb.toString());
                case '\\':
                    char next = reader.next();
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
                            chars[0] = reader.next();
                            chars[1] = reader.next();
                            chars[2] = reader.next();
                            chars[3] = reader.next();
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
        if (reader.next() == 'a' && reader.next() == 'l' && reader.next() == 's' && reader.next() == 'e') {
            return new Token(TokenTypeEnum.BOOLEAN, false);
        }
        throw new RuntimeException("invalid json");
    }

    private Token readTrue() {
        if (reader.next() == 'r' && reader.next() == 'u' && reader.next() == 'e') {
            return new Token(TokenTypeEnum.BOOLEAN, true);
        }
        throw new RuntimeException("invalid json");
    }

    private Token readNull() {
        if (reader.next() == 'u' && reader.next() == 'l' && reader.next() == 'l') {
            return new Token(TokenTypeEnum.NULL);
        }
        throw new RuntimeException("invalid json");
    }
}
