import java.util.PrimitiveIterator;

public class Awesome_43_MultiplyStrings {
    /*
    2020.03.29
    乍一看没有思路，没见过.

    Given two non-negative integers num1 and num2 represented as strings,
    return the product of num1 and num2, also represented as a string.

    Example1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

    Example2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"

    100 min

    */

    private static int method1(String num1, String num2) {
        // 1. Consider zero
        // 2. Implement Multi-digit Multiplication

        if (num1.equals("0") || num2.equals("0")) {
            return 0;
        }
//        int zeros = (num1.length() >= num2.length())? num1.length():num2.length();
//        int zeros = Math.max(num1.length(), num2.length());
        int zeros = 0;
        // 12 x 8
        //   12 - num1
        //    8 - num2
        // ----
        //   16
        //   8
        // ----
        //   96

        // 2*8 = 16
        // 1*8 = 8
        //       96

        // 96 = 8 * 10 + 16 * 1

        // 121 * 8
        //    121
        //      8
        //    ---
        //      8
        //    16
        //    8
        //    ---
        //    968
        // 8 * 100 + 16 * 10 + 8 * 1

        // 12 * 12
        //
        //      12
        //      12
        //    ----
        //      24
        //     24
        //    ----
        //     264
        //     264 = 24 * 10 + 24 * 1

        // 2 * 121
        //       2
        //     121
        //     ---
        //       2
        //      4
        //     2
        //     ---
        //     242
        //     242 = 2 * 100 + 4 * 10 + 2 * 1

        int result = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int digit = num2.charAt(i) - '0';
            result += xByOneDigit(num1, digit) * 1 * Math.pow(10, zeros);
            zeros++;
        }
        // 这个地方还是用int表示的，不行
        // 因为在相加的时候用了乘法，即result += temp * digit2 * 1 * Math.pow(10, zeros)
        // 所以最后还是变成了一个int
        // 应该使用方法二里 sumTwoString 方法
        return result;
    }

    private static int xByOneDigit(String num1, int digit2) {
        int length = num1.length();
        int result = 0;
        int zeros = 0;
        for (int i = length - 1; i >= 0; i--) {
             int temp = num1.charAt(i) - '0';
             result += temp * digit2 * 1 * Math.pow(10, zeros);
             zeros++;
        }
        return result;
    }

    private static String method2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String ans = "0";
        int index = 0;
        for (int i = num2.length() - 1 ; i >= 0; i--) {
            int remain = 0;
            String ans_temp= "";
            int m = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n = num1.charAt(j) - '0';
                int mul = m * n + remain;
                ans_temp = mul % 10 + "" + ans_temp;
                remain = mul / 10;
            }

            System.out.println("ans_temp " + ans_temp);

            if (remain > 0) {
                ans_temp = remain + "" + ans_temp;
            }

            for (int k = 0; k < index; k++) {
                ans_temp = ans_temp + "0";
            }
            index++;
            ans = sumTwoString(ans, ans_temp);
        }
        return ans;
    }

    private static String sumTwoString(String num1, String num2) {
        int remain = 0;
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        String ans = "";
        while (num1_index >= 0 || num2_index >= 0) {
            int n1 = num1_index >= 0 ? num1.charAt(num1_index) - '0' : 0;
            int n2 = num2_index >= 0 ? num2.charAt(num2_index) - '0' : 0;
            int sum = n1 + n2 + remain;
            remain = sum / 10;
            ans = sum % 10 + "" + ans;
            num1_index--;
            num2_index--;
        }
        if (remain > 0) {
            ans = remain + "" + ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(method2("123","10"));
    }
}
