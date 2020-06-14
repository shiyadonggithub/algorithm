package leetcode;

import java.util.Arrays;

public class _07Reverse {
    public static void main(String[] args) {
        int x = 2147483602;
        _07Reverse reverse = new _07Reverse();
        System.out.println(reverse.reverse(x));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//        System.out.println((-1)%10);
//        System.out.println(x + "");
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (res < 0 && (Integer.MIN_VALUE - temp) / 10 > res)
                return 0;
            if (res > 0 && (Integer.MAX_VALUE - temp) / 10 < res)
                return 0;
            res = temp + res * 10;
        }
        return res;
    }
}
