package linked_list;

/**
 * Description: https://leetcode.com/problems/swapping-nodes-in-a-linked-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;

        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        ListNode kthFromStart = fast;
        ListNode kthFromEnd = head;
        while (fast.next != null) {
            kthFromEnd = kthFromEnd.next;
            fast = fast.next;
        }

        if (kthFromStart == kthFromEnd) return head;

        int tmp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = tmp;

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
