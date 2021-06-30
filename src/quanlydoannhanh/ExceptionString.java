package quanlydoannhanh;

import java.io.UnsupportedEncodingException;

public class ExceptionString {

    public static boolean isNumber(String input) {
        boolean kt = false;
        for (int i = 0; i < input.length(); i++) {
            kt = Character.isDigit(input.charAt(i));
        }
        return kt;
    }

    public static boolean isSpace(String input) {
        boolean kt = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                kt = true;
            }
        }
        return kt;

    }

    public static boolean isUnicode(String input) throws UnsupportedEncodingException {
        boolean kt = false;
        int utf8BytesCount = input.getBytes("UTF-8").length;
        int asciiBytesCount = input.getBytes("ASCII").length;
        if (utf8BytesCount != asciiBytesCount) {
            kt = true;
        }
        return kt;
    }
}
