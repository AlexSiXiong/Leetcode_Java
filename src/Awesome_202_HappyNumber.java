import java.util.HashSet;

public class Awesome_202_HappyNumber {
    /*
    2020.04.02

    30 days challenge

    day 2

    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number
    by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
    or it loops endlessly in a cycle which does not include 1.

    Those numbers for which this process ends in 1 are happy numbers.

    Example 1:
    Input: 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

    Example 2:
    Input: 2
    Output: false
    Explanation:
    1^2 + 1^2 = 2
    2^2 = 4
    4^2 = 16
    1^2 + 6^2 = 37
    3^2 + 7^2 = 58
    5^2 + 8^2 = 89
    8^2 + 9^2 = 145
    1^2 + 4^2 + 5^2 = 42
    4^2 + 2^2 = 20
    2^2 + 0^2 = 4

    考点：
    1. 这其实是个数学题, 哈哈哈, 高中数学

    2. 在理解了1之后就会发现，编程考点可以是HashSet

    20 min
     */

    private static boolean method1(int n) {
        String string_int = Integer.toString(n);
        HashSet<Integer> set = new HashSet<>();
        int temp_sum = 0;
        while (temp_sum != 1) {
            temp_sum = 0;
            for (int i = 0; i < string_int.length(); i++) {
                int current = string_int.charAt(i) - '0';
                temp_sum+= Math.pow(current,2);
            }

            if (set.contains(temp_sum)) {
                return false;
            }
            set.add(temp_sum);

            string_int = Integer.toString(temp_sum);

        }
        return true;
    }

    private static boolean method2(int n) {
        // optimize method1
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true) {
            int next = getNext(n);
            if (next == 1) {
                return true;
            }

            if (set.contains(next)) {
                return false;
            } else {
                set.add(next);
                n = next;
            }
        }
    }

    private static int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int t = n % 10;
            next += t * t;
            n /= 10;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(method1(2));
    }
}
