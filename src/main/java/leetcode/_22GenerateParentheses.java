package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _22GenerateParentheses {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(2);
        Iterator<String> iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        bp(0, 0, "", result, n);
        return result;
    }

    public static void bp(int left, int right, String str, List<String> result, int n) {
        if (left < n) {
            bp(left + 1, right, str + "(", result, n);
        }
        if (right < left) {
            bp(left, right + 1, str + ")", result, n);
        }
        if (left == right && left == n) {
            result.add(str);
        }
    }
}
