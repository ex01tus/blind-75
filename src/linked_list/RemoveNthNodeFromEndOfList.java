package linked_list;

/**
 * Description: https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) { // n == list.size() -> head deletion
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    private static class ListNode {
        ListNode next;
    }
}
