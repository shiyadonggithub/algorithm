package leetcode;

public class _32LongestValidParentheses {
    public static void main(String[] args) {
        _32LongestValidParentheses longestValidParentheses = new _32LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int result = 0;

        if (s.length() < 2) return result;
        int[] dpArray = new int[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                dpArray[i] = i + 1;
                result = 2;
            }
        }
        for (int length = 4; length < s.length() + 1; length += 2) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                if (s.charAt(i) == '(' && s.charAt(i + length - 1) == ')') {
                    if (dpArray[i + 1] == i + length - 2) {
                        dpArray[i] = i + length - 1;
                        result = length;
                    } else if (dpArray[i] > 0) {
                        int j = dpArray[i];
                        while (j < i + length) {
                            if (j == i + length - 1) {
                                result = length;
                                dpArray[i] = i + length - 1;
                                break;
                            }
                            j += 1;
                            if (dpArray[j] > 0)
                                j = dpArray[j];
                            else break;
                        }
                    }
                }
            }
        }

        return result;
    }
}