import java.util.LinkedList;

public class Alex_19_RemoveNthNodeFromEndofList {
    /*
    2019.10.23
    first try - review LinkedList

    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:
    Given n will always be valid.
     */

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // get the total length of the ListNode
        // identify the position - n

        // index.next = index.next.next
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode first = head;

        int length = 0;

        while (first != null) {
            length++;
            first = first.next;
        }
        // 1,2,3,4,5
        // n = 2
        // 0,1,2, ,4,5
        int stop_point = length - n;

        first = dummyHead;

        for (int i = 0; i < stop_point; i++) {
            if (first.next == null) return head;
            first = first.next;
        }

        first.next = first.next.next;


        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);



        ListNode result = removeNthFromEnd(example, 2);
        while(result != null) {
            System.out.print(result.val);
            System.out.print(" -> ");
            result = result.next;
        }


    }
}