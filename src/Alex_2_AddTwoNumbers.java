import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Alex_2_AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */

    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    private static LinkedList method1(LinkedList l1, LinkedList l2) {
        // 1. read digit in list
        // 2. reverse the number read from list
        // 3. convert data format from string to integer
        // 4. sum
        // 5. store the sum back into a linked list

        String number1 = convertListToString(l1);
        String number2 = convertListToString(l2);

        int sum = Integer.parseInt(number1) + Integer.parseInt(number2);

        LinkedList<Integer> result = new LinkedList<>();

        while (sum % 10 != 0) {
            result.add(sum % 10);
            sum = sum / 10;
        }

        return result;
    }

    private static String convertListToString(LinkedList list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();


        int a = 123;
        while (a % 10 != 0) {
            linkedList.add(a % 10);
            a /= 10;
        }

        StringBuilder number1 = new StringBuilder();

        for (int i = 0; i < linkedList.size(); i++) {
            number1.append(linkedList.get(i));
        }
        System.out.println(number1.reverse().toString());


        // to some extend, i think non-it cases are easier to understand
        // you don't really need any background about the case
        //you think our is easy to understand? no!
    }


}
