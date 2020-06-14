package leetcode;

import java.util.HashMap;

public class _03LengthOfLongestSubstring {
    public static void main(String[] args) {
        _03LengthOfLongestSubstring lengthOfLongestSubstring = new _03LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        //for (int i = 0; i < s.length(); i++) {
        int begin = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int j = 0; j < s.length(); j++) {
            if (hashMap.containsKey(s.charAt(j)) && hashMap.get(s.charAt(j)) >= begin) {
                begin = hashMap.get(s.charAt(j)) + 1;
            }
            result = result > j - begin + 1 ? result : j - begin + 1;
            hashMap.put(s.charAt(j), j);
        }
        //  }
        return result;
    }
}
