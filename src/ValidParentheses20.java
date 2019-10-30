/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.
 */

import java.util.Stack;

public class ValidParentheses20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) return false;
                char topOnStack = stack.pop();
                if (topOnStack == '(' && current != ')') {
                    return false;
                } else if (topOnStack == '[' && current != ']') {
                    return false;
                } else if (topOnStack == '{' && current != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // ( ( [ ] )
    }

    public static void main(String[] args) {
        System.out.println(isValid("(([])"));
        System.out.println(isValid("()[]"));
    }
}
