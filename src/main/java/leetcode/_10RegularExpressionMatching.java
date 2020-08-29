package leetcode;

public class _10RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println("hello world");
        String p = "ab*a*c*a";
        String s = "aaa";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] matchArray = new boolean[m + 1][n + 1];
        matchArray[0][0] = true;

        for (int i = 1; i < m + 1; i++) {
            if (i == 1) {
                matchArray[i][0] = false;
            }
            if (p.charAt(i - 1) == '*') {
                matchArray[i][0] = (matchArray[i - 1][0] || matchArray[i - 2][0]);
            }
        }

        for (int j = 1; j < n + 1; j++) {
            matchArray[0][j] = false;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int pIndex = i - 1;
                int sIndex = j - 1;
                if (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) {
                    matchArray[i][j] = matchArray[i - 1][j - 1];
                } else if (p.charAt(pIndex) == '*') {
                    if (pIndex - 2 >= 0) {
                        if (p.charAt(pIndex - 2) == '.') {
                            matchArray[i][j] = matchArray[i - 3][j - 1];
                        }
                        if (!matchArray[i][j] && p.charAt(pIndex - 2) == s.charAt(sIndex)) {
                            matchArray[i][j] = matchArray[i - 3][j - 1];
                        }
                        if (!matchArray[i][j]) {
                            matchArray[i][j] = matchArray[i - 2][j];
                        }
                    }

                    if (pIndex - 1 >= 0) {
                        if (!matchArray[i][j] && p.charAt(pIndex - 1) == s.charAt(sIndex)) {
                            matchArray[i][j] = (matchArray[i - 2][j - 1] || matchArray[i][j - 1]);
                        }

                        if (!matchArray[i][j] && p.charAt(pIndex - 1) == '.') {
                            matchArray[i][j] = (matchArray[i - 2][j - 1] || matchArray[i][j - 1]);
                        }

                        if (!matchArray[i][j]) {
                            matchArray[i][j] = matchArray[i - 1][j];
                        }
                    }
                }
            }
        }

//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(matchArray[i][j]);
//                System.out.print("  ");
//            }
//            System.out.println();
//        }
        return matchArray[m][n];
    }
}
