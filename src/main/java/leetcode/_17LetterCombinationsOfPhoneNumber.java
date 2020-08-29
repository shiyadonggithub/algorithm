package leetcode;

import java.util.*;

public class _17LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        //System.out.println(digits.substring(1, 2));
        List<String> list = letterCombinations(digits);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>() {
            {
                put(2, "abc");
                put(3, "def");
                put(4, "ghi");
                put(5, "jkl");
                put(6, "mno");
                put(7, "pqrs");
                put(8, "tuv");
                put(9, "wxyz");
            }
        };
        List<String> list = new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        backTracking(list, 0, "", digits, hashMap);
        return list;
    }

    public static void backTracking(List<String> list, int index, String preStr, String digits, Map<Integer, String> hashMap) {
        for (int i = 0; i < hashMap.getOrDefault(digits.charAt(index) - '0', "").length(); i++) {
            String curStr = preStr + hashMap.get(digits.charAt(index) - '0').substring(i, i + 1);
            if (index == digits.length() - 1) {
                list.add(curStr);
                //return;
            } else {
                backTracking(list, index + 1, curStr, digits, hashMap);
            }
        }
    }

}
