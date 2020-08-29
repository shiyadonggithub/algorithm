package leetcode;

public class _12IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String result = "";

        if (num / 1000 > 0) {
            for (int i = 0; i < num / 1000; i++) {
                result = result.concat("M");
            }
            num %= 1000;
        }
        if (num >= 900) {
            result = result.concat("CM");
            num %= 900;
        }
        if (num >= 500) {
            result = result.concat("D");
            num %= 500;
        }

        if (num >= 400) {
            result = result.concat("CD");
            num %= 400;
        }
        if (num >= 100) {
            for (int i = 0; i < num / 100; i++)
                result = result.concat("C");
            num %= 100;
        }

        if (num >= 90) {
            result = result.concat("XC");
            num %= 90;
        }

        if (num >= 50) {
            result = result.concat("L");
            num %= 50;
        }
        if (num >= 40) {
            result = result.concat("XL");
            num %= 40;
        }

        if (num >= 10) {
            for (int i = 0; i < num / 10; i++)
                result = result.concat("X");
            num %= 10;
        }
        if (num >= 9) {
            result = result.concat("IX");
            num %= 9;
        }
        if (num >= 5) {
            result = result.concat("V");
            num %= 5;
        }
        if (num >= 4) {
            result = result.concat("IV");
            num %= 4;
        }
        for (int i = 0; i < num; i++) {
            result = result.concat("I");
        }

        return result;
    }
}
