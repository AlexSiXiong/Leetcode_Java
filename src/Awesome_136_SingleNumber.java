public class Awesome_136_SingleNumber {
    /*
    2020.04.01

    30 days challenge

    day 1

    Given a non-empty array of integers, every element appears twice except for one.
    Find that single one.

    考点：

    异或 - XOR

    1. 只要两个相同的数进行异或运算，结果为0；
    2. 结合律（即(a^b)^c == a^(b^c)）
    3. 交换律 a ^ b = b ^ a
    4. 对于任何数x，都有x^x=0，x^0=x
    5. 自反性 A XOR B XOR B = A xor 0 = A
     */

    private static int method1 (int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        System.out.println(method1(nums));
    }
}
