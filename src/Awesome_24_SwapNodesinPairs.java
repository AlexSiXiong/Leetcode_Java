public class Awesome_24_SwapNodesinPairs {
    /*
    2019.11.03

    Given a linked list, swap every two adjacent nodes and return its head.

    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Paths in brain:
    Comparing a pair of nodes every round
    1. complete the logic of comparing a pair of nodes
    2. complete condition
     */

    private static ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode anchor = result;
        while(head != null && head.next != null) {
            int position1 = head.val;
            int position2 = head.next.val;
            result.next = new ListNode(position2);
            result.next.next = new ListNode(position1);
            result = result.next.next;
            head = head.next.next;
        }
        if (head == null) {
            return anchor.next;
        } else {
            result.next = head;
        }
        return anchor.next;
    }

    private static void printListNodes(ListNode nodes) {
        StringBuilder result = new StringBuilder();
        while (nodes != null) {
            result.append(nodes.val);
            result.append(" -> ");
            nodes = nodes.next;
        }
        result.append(" null");

        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(100);
        l2.next.next.next.next = new ListNode(50);

        printListNodes(l2);

        swapPairs(l2);
    }
}
