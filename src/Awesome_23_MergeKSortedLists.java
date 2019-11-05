import java.util.*;

public class Awesome_23_MergeKSortedLists {
    /*
    2019.11.03

    Merge k sorted linked lists and return it as one sorted list.
    Analyze and describe its complexity.

    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6

    Paths in brain:
    similar to Q.21
     */



    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        HashMap<Integer, Integer> dic = new HashMap<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode currentListNode = lists[i];

            while(currentListNode != null) {
                if (!dic.containsKey(currentListNode.val)) {
                    dic.put(currentListNode.val, 1);
                } else {
                    dic.put(currentListNode.val, dic.get(currentListNode.val) + 1);
                }
                // 写错了，花了几分钟写了个辅助函数debug
                // misspelling a word...
                currentListNode = currentListNode.next;
            }
        }

        List<Integer> keyList = new ArrayList<>(dic.keySet());
        Collections.sort(keyList);

        for (int i = 0; i < keyList.size(); i++) {
            int currentDigit = keyList.get(i);
            int times = dic.get(currentDigit);
            for (int j = 1; j <= times; j++) {
                currentNode.next = new ListNode(currentDigit);
                currentNode = currentNode.next;
            }
        }
        return result.next;
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(100);
        l2.next.next.next.next = new ListNode(50);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        l3.next.next = new ListNode(9);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;

        for (ListNode item:
             listNodes) {
            printListNodes(item);
        }
        System.out.println("---");
        mergeKLists(listNodes);

        double a = 64.71;
        double b = 24.54;
        double c = 3.91;
        double d = 1.09;
        double e = 5.75;
        System.out.println(a+b+c+d+e);

    }
}
