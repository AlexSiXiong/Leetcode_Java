package Practices;

public class SumStrings {
    /*
    2020.03.29

    加法

    Sum to numbers in the form of String

    Not allowed to convert String to Integer directly

    This exercise is inspired by Q.41
    */

    private static String sumTwoStrings(String num1, String num2) {
        // 注意：
        //    这个地方减1，机器读取位数和人读取位数不一样

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        int second_position = 0;
        String result = "";

        while (l1 >= 0|| l2 >= 0) {
            int digit1 = l1 >=0 ? num1.charAt(l1) - '0': 0;
            int digit2 = l2 >=0 ? num2.charAt(l2) - '0': 0;

            int current_sum = digit1 + digit2 + second_position;
            second_position = current_sum / 10; // 比如 12 / 10 = 1, 把进一位的数拿出来，下一次要用
            int first_position = current_sum % 10;
            result = first_position + "" + result; // % 获得余数，即个位数，直接累加到最终result里


            l1--;
            l2--;
        }

        if (second_position != 0) {
            result = second_position + "" + result;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumTwoStrings("10", "3"));
    }
}
