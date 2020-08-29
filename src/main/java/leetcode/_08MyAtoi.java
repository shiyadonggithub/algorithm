package leetcode;

import scala.Char;

public class _08MyAtoi {
    public static void main(String[] args) {
        String str = " +1000  8888888888888";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        int result = 0;
        str = str.trim();
        if (str.isEmpty())
            return result;
        char[] chars = str.toCharArray();
        boolean negative = false;
        int index = 0;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return result;
        }
        while (index < chars.length) {
            if (Character.isDigit(chars[index])) {
                int value = chars[index] - '0';
                if (negative) {
                    value *= -1;
                    if ((Integer.MIN_VALUE - value) / 10 > result)
                        return Integer.MIN_VALUE;
                    else {
                        result = result * 10 + value;
                    }
                } else {
                    if ((Integer.MAX_VALUE - value) / 10 < result) {
                        return Integer.MAX_VALUE;
                    } else {
                        result = result * 10 + value;
                    }
                }
                index++;
            } else {
                return result;
            }
        }
        return result;
    }
}
