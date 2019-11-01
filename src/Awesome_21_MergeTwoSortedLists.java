import java.lang.reflect.Array;
import java.util.*;

public class Awesome_21_MergeTwoSortedLists {
    /*
    2019.11.02

    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4

    Paths in brain:
    1.go through list1 + go through list2
    store elements in a dictionary -> sort keys

    2.go through list1 + go through list2
    compare each element
    */

    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode result = currentNode;
        HashMap<Integer, Integer> dic = new HashMap<>();
        while(l1 != null) {
            if (!dic.containsKey(l1.val)) {
                dic.put(l1.val, 1);
            } else {
                dic.put(l1.val, dic.get(l1.val) + 1);
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            if (!dic.containsKey(l2.val)) {
                dic.put(l2.val, 1);
            } else {
                dic.put(l2.val, dic.get(l2.val) + 1);
            }
            l2 = l2.next;
        }

        List<Integer> keysList = new ArrayList<>(dic.keySet());
        Collections.sort(keysList);

        for(int i = 0; i < keysList.size(); i++) {
            int currentDigit = keysList.get(i);
            int times = dic.get(currentDigit);
            for (int j = 1 ;j <= times; j++) {
                currentNode.next = new ListNode(currentDigit);
                currentNode = currentNode.next;
            }
        }
//        for (int i : keysList) {
//            System.out.println(i);
//        }


        return result.next;
    }

    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode result = currentNode;

        while(l1 != null && l2 != null) {
            int currentL1NodeValue = l1.val;
            int currentL2NodeValue = l2.val;

            if (currentL1NodeValue <= currentL2NodeValue) {
                currentNode.next = new ListNode(currentL1NodeValue);
                l1 = l1.next;
            } else {
                currentNode.next = new ListNode(currentL2NodeValue);
                l2= l2.next;
            }

            currentNode = currentNode.next;
        }
        if (l1 == null) {
            currentNode.next = l2;
        }
        if (l2 == null) {
            currentNode.next = l1;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(100);
        l2.next.next.next.next = new ListNode(50);

        mergeTwoLists1(l1, l2);
    }
}
