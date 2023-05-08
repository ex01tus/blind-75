package linked_list;

/**
 * Description: https://leetcode.com/problems/reverse-nodes-in-k-group
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = length(head);
        int reversalNumber = length / k;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prevToReversed = dummy;
        for (int i = 0; i < reversalNumber; i++) {
            ReversalResult result = reverseNextN(prevToReversed.next, k);

            prevToReversed.next = result.head;
            prevToReversed = result.tail;
        }

        return dummy.next;
    }

    private ReversalResult reverseNextN(ListNode head, int n) {
        ListNode reversedTail = head;
        ListNode prev = null;
        for (int i = 0; i < n; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        reversedTail.next = head;

        return new ReversalResult(
                prev,          // head
                reversedTail); // tail
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    private record ReversalResult(ListNode head, ListNode tail) {
    }

    private static class ListNode {
        ListNode next;
    }
}
