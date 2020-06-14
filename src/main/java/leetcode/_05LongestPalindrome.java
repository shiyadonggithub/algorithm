package leetcode;

public class _05LongestPalindrome {
    public static void main(String[] args) {
        _05LongestPalindrome longestPalindrome = new _05LongestPalindrome();
        String test = "babad";
        System.out.println("test:" + test.substring(0, 2));
        System.out.println(longestPalindrome.longestPalindrome("abcda"));
    }

    public String longestPalindrome(String s) {
        //String result = "";
        if (s.length() == 1) return s;
        int[][] p = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                p[i][j] = 0;
            }
        }
        int begin = 0, end = 0;

        //初始化length=1
        for (int i = 0; i < s.length(); i++) {
            p[i][i] = 1;
            begin = i;
            end = i + 1;
        }

        //初始化 length=2
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = 1;
                begin = i;
                end = i + 2;
            }

        }
        //
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                if (s.charAt(i) == s.charAt(i + len) && p[i + 1][i + len - 1] == 1) {
                    p[i][i + len] = 1;
                    begin = i;
                    end = i + len + 1;
                }
            }
        }
        //return result;
        return s.substring(begin, end);
    }
}
