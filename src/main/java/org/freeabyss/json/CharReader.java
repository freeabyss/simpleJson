package org.freeabyss.json;

public class CharReader {

    private final String str;
    private int pos = 0;

    public CharReader(String str) {
        this.str = str;
    }

    public char next() {
        return str.charAt(pos++);
    }

    public boolean hasNext() {
        return pos < str.length();
    }

    /**
     * 回退一个字符
     */
    public void back() {
        pos--;
    }


}
