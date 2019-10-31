public class Awesome_8_StringToInteger {
    /*
    2019.10.17

    Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note：
    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

    Input: "42"
    Output: 42

    Input: "-42"
    Output: -42

    Input: "w42"
    Output: 0

    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.

    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 Therefore INT_MIN (−231) is returned.

    Input: "-123aa123"
    Output: -123

    -- How about --
    Input: "+-123aa123"
    Output: ?
     */

    private static int myAtoi(String str) {
        // if want to O(n)
        // must rely on math
        if (str.length() == 0) return 0;
        char firstChar = str.charAt(0);

        int result = 0;
        int tail = 0;

        boolean begin = false;
        boolean negative = false;

        if (firstChar > '0' && firstChar <= '9') {
            begin = true;
        }

        for (int i = 0; i < str.length(); i++) {

            char currentOne = str.charAt(i);
            if (i >= 1) {
                char preChar = str.charAt(i - 1);
                if (currentOne != '0' && preChar == '0') {
                    begin = true;
                }
            }

            if (currentOne == '+' && !begin) {
                begin = true;
                continue;
            }

            if (currentOne == '-' && !begin) {
                begin = true;
                negative = true;
                continue;
            }



            if (begin && currentOne > '0' && currentOne <= '9') {

                // check Integer Overflows
                if (result > Integer.MAX_VALUE / 10) {
                    if (negative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                tail = currentOne - '0';
//                if (result * 10 + tail == -2147483648) {
//                    return Integer.MAX_VALUE;
//                }
//                if (result * 10 + tail == 2147483647) {
//                    return Integer.MIN_VALUE;
//                }
                result = result * 10 + tail;

            }

            if (begin && (currentOne < '0'|| currentOne > '9')) {
                System.out.println("here");
                break;
            }
        }
        System.out.println(negative);
        if (negative) {
            result = result * -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483647"));
    }

}
