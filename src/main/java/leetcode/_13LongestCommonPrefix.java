package leetcode;

public class _13LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0)
            return result;
        result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j;
            for (j = 0; j < Math.min(result.length(), strs[i].length()); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0,j);
        }
        return result;
    }
}

