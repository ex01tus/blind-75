package linked_list;


/**
 * Description: https://leetcode.com/problems/swap-nodes-in-pairs
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        ListNode current = head;
        ListNode prev = dummy;

        while (current != null && current.next != null) {
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;

            prev = current;
            current = current.next;
        }

        return dummy.next;
    }

    private static class ListNode {
        ListNode next;
    }
}
