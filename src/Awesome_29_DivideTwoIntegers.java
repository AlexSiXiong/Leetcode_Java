public class Awesome_29_DivideTwoIntegers {
    /*
    2019.11.05

    * Math
    * Stack overflow

    Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

    Return the quotient after dividing dividend by divisor.

    The integer division should truncate toward zero.

    Input: dividend = 10, divisor = 3
    Output: 3
     */

    private static int divide(int dividend, int divisor) {
        int ans = -1;
        int sign = 1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int origin_dividend = dividend;
        int origin_divisor = divisor;
        if (dividend > divisor) {
            return 0;
        }

        dividend -= divisor;
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        //此时我们传进的是两个负数，正常情况下，它就返回正数，但我们是在用负数累加，所以要取相反数
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
        if(a == Integer.MIN_VALUE){
            if( sign > 0){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }else{
            if(sign > 0){
                return opposite(a);
            }else{
                return a;
            }
        }
    }
    private static int opposite(int x) {
        return ~x + 1;
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.println(~x);
    }
}
