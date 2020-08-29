package leetcode;

import java.util.Stack;

public class _20ValidParentheses {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if (top != '[')
                    return false;
                else if(top == '[')
                    continue;
            }
            if (s.charAt(i) == ')' ) {
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if (top != '(')
                    return false;
                else if(top == '(')
                    continue;
            }
            if (s.charAt(i) == '}' ) {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if (top != '{')
                    return false;
                else if(top == '{')
                    continue;
            }
            if (s.charAt(i) != '{' && s.charAt(i) != '[' && s.charAt(i) != '(') {
                return false;
            }
            stack.push(s.charAt(i));
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
