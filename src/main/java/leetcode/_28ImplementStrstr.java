package leetcode;

import sun.plugin.javascript.navig.Array;
public class _28ImplementStrstr {
    public static void main(String[] args) {
        _28ImplementStrstr implementStrstr = new _28ImplementStrstr();
        String haystack = "llellollsllolle";
        String needle = "llolle";
        System.out.println(implementStrstr.strStrBf(haystack, needle));

        //int[] prefix = implementStrstr.initPrefix(needle);

        System.out.println();

        System.out.println(implementStrstr.strStrKmp(haystack, needle));

    }

    public int strStrKmp(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] prefix = initPrefix(needle);
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            System.out.println(i);
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    if (j > 0)
                        i += (prefix[j - 1] - 1);
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
//        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//            if(haystack.substring(i, needle.length()+i).equals(needle)){
//                return i;
//            }
//            i += (prefix[i]-1);
//        }
        return -1;
    }

    public int strStrBf(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int[] initPrefix(String needle) {
        int[] prefix = new int[needle.length()];
        prefix[0] = 1;
        for (int i = 1; i < needle.length(); i++) {
            prefix[i] = 1;
            for (int j = i; j > 0; j--) {
                String prefixStr = needle.substring(0, j);
                String suffixStr = needle.substring(i - j + 1, i + 1);
                if (prefixStr.equals(suffixStr)) {
                    prefix[i] = i - j + 1;
                    break;
                }
            }
        }
        return prefix;
    }
}
