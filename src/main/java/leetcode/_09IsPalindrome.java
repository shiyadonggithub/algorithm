package leetcode;

import scala.Int;

public class _09IsPalindrome {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x){
        if(x < 0)
            return false;
        String str = Integer.toString(x);
        int j = str.length()-1;
        int i = 0;
        while (i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
