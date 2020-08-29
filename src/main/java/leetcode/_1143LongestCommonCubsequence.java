package leetcode;

import javafx.application.Application;
import javafx.stage.Stage;

public class _1143LongestCommonCubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        _1143LongestCommonCubsequence longestCommonCubsequence = new _1143LongestCommonCubsequence();
        System.out.println(longestCommonCubsequence.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        int result = 0;
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
            result = 1;
        }

        for (int i = 1; i < text1.length(); i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
            result = Math.max(result, dp[i][0]);
        }
        for (int j = 1; j < text2.length(); j++) {
            dp[0][j] = text1.charAt(0) == text2.charAt(j) ? 1 : dp[0][j - 1];
            result = Math.max(result, dp[0][j]);
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
