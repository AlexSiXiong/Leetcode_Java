public class Awesome_32_LongestValidParentheses {
    /*
    2019.11.09

    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    Example 1:

    Input: "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()"
    Example 2:

    Input: ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()"

    Path in Brain:
    checking on pair of parentheses every round by ++ and -- of a counter

     */

    public int longestValidParentheses(String s) {
        int longest = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter = 0;
            for (int j = i; j < s.length(); j++) {
                // only ( or ) in the input
                if (s.charAt(j) == '(') {
                    counter++;
                } else {
                    counter--;
                }
                if (counter < 0) {
                    break;
                }
                if (counter == 0) {
                    if (j - i + 1 > longest) {
                        longest = j - i + 1;
                    }
                }
            }
        }
        return longest;
    }
}
