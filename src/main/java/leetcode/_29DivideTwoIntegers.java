package leetcode;

import org.apache.flink.streaming.api.functions.IngestionTimeExtractor;

public class _29DivideTwoIntegers {
    public static void main(String[] args) {
        _29DivideTwoIntegers divideTwoIntegers = new _29DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648
                , 1));

    }


    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend ^ divisor) < 0;

        long t = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += (1 << i);
                t -= (d << i);
            }
        }
        return negative ? (int)-result : (int)result;
    }
}