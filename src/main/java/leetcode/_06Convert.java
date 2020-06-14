package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _06Convert {
    public static void main(String[] args) {
        System.out.println("main start");
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        _06Convert convert = new _06Convert();
        System.out.println(convert.convert2(s, numRows));
//        System.out.println(s.substring(0, 16));
//        int i = 1;
//        System.out.println(s.substring(i * (numRows * 2 - 2), (i + 1) * (numRows * 2 - 2)));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        String result = "";
        int length = s.length();
        Map<Integer, Map<Integer, String>> map = new HashMap<Integer, Map<Integer, String>>();
        for (int i = 0; i < (length / (numRows * 2 - 2)) + 1; i++) {
            String curStr = s.substring(i * (numRows * 2 - 2),
                    Math.min((i + 1) * (numRows * 2 - 2), s.length()));
            Map<Integer, String> mapValue = new HashMap<Integer, String>();
            for (int j = 0; j < numRows; j++) {
                String mapValueValue = "";
                if (j == numRows - 1 && j < curStr.length()) {
                    mapValueValue = curStr.substring(j, j + 1);
                } else {
                    if (j < curStr.length()) {
                        mapValueValue = curStr.substring(j, j + 1);
                    }
                    if ((numRows * 2 - 2 - j) < curStr.length()) {
                        mapValueValue = mapValueValue + curStr.substring(numRows * 2 - 2 - j, numRows * 2 - 1 - j);
                    }
                }
                mapValue.put(j, mapValueValue);
            }
            map.put(i, mapValue);
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < (length / (numRows * 2 - 2)) + 1; j++) {
                Map<Integer, String> mapValue = map.get(j);
                if (mapValue != null)
                    result = result + mapValue.get(i);
            }
        }
        return result;
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
//        String result = "";
        char[] result = new char[s.length()];
        int globalIndex = 0;
        //按行访问
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < (s.length() / (numRows * 2 - 2)) + 1; i++) {
                String curStr = s.substring(i * (numRows * 2 - 2),
                        Math.min((i + 1) * (numRows * 2 - 2), s.length()));
                if (j == numRows - 1 && j < curStr.length()) {
                    result[globalIndex++] = curStr.charAt(j);
                } else {
                    if (j < curStr.length()) {
                        result[globalIndex++]= curStr.charAt(j);
                    }
                    if ((numRows * 2 - 2 - j) < curStr.length()) {
                        result[globalIndex++] = curStr.charAt(numRows * 2 - 2 - j);
                    }
                }
            }
        }
        return new String(result);
    }
}
