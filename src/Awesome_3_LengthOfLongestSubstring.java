import java.util.HashSet;
import java.util.Set;

public class Awesome_3_LengthOfLongestSubstring {
    /*
    2019.10.15
    First time

    Given a string, find the length of the longest substring without repeating characters.

    Example 1:
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    E 2:
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    E 3:
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    // first time
    private static int method1(String str) {
        // The result only requires return the length of [the length] of the longest substring
        // without repeating characters

        // 'without repeating' -> We may use Set
        // 'characters' -> Char

        // notice: return the length of ...

        int head = 0;
        int tail = 0;
        int length = str.length();
        int result = 0;
        Set<Character> box = new HashSet<>();

        while (head < length && tail < length) {
            if (box.contains(str.charAt(tail))) {
                box.remove(str.charAt(head));
                head += 1;
            } else {
                box.add(str.charAt(tail));
                tail += 1;
                result = Math.max(result, tail - head);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String test0 = "abcd";
        String test1 = "abcabcbb";
        String test2 = "bbb";
        String test3 = "pwwkew";
        String test4 = "paaa";
        String test5 = "pppa";

        System.out.println(method1(test0) == 4);
        System.out.println(method1(test1) == 3);
        System.out.println(method1(test2) == 1);
        System.out.println(method1(test3) == 3);
        System.out.println(method1(test4) == 2);
        System.out.println(method1(test5) == 2);
    }

}
