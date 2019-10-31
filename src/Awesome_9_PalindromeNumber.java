public class Awesome_9_PalindromeNumber {
    /*
    2019.10.17
    second try

    Determine whether an integer is a palindrome.
    An integer is a palindrome when it reads the same backward as forward.

    Input: 121
    Output: true

    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */

    private static boolean isPalindrome1(int x) {
        // reverse the number
        // then compare with the original one
        if (x < 0) return false;
        int reserved_num = 0;
        int temp = x;

        while (temp != 0) {
            int tail = temp % 10;
            temp = temp / 10;
            if (reserved_num > Integer.MAX_VALUE / 10) return false;
            if (reserved_num < Integer.MIN_VALUE / 10) return false;
            reserved_num = reserved_num * 10 + tail;
        }

        return x == reserved_num;
    }

    private static boolean isPalindrome2(int x) {
        // reverse half of the digits in the number
        // then compare with the other half of the digits
        if (x < 0 || x % 10 == 0) return false;

        int digits = (int) (Math.log(x) / Math.log(10) + 1);
        boolean odd = false;
        if (digits % 2 == 1) odd = true;
        int right_part = 0;
        int times = 1;
        while ( times <= digits / 2 ) {
            int tail = x % 10;
            right_part = right_part * 10 + tail;
            times ++;
            x = x / 10;
        }

        if (odd) {
            x = x / 10;
            return x == right_part;
        } else {
            return x == right_part;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12322));
    }
}
