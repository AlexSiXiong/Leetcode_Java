public class Alex_7_ReverseInteger {
    /*
    2019.10.17
    Second Try

    Given a 32-bit signed integer, reverse digits of an integer.

    Input: 123
    Output: 321

    Input: -123
    Output: -321

    Note:
    Assume we are dealing with an environment which could only store integers within
    the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem,
    assume that your function returns 0 when the reversed integer overflows.
     */

    private static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            x = x / 10;
            // if result > Integer.MAX_VALUE / 10
            // it will cause integer overflows for sure
            // because the next step is [ result * 10 ]
            if (result > Integer.MAX_VALUE / 10) return 0;
            if (result < Integer.MIN_VALUE / 10) return 0;
            result = result * 10 + tail;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
