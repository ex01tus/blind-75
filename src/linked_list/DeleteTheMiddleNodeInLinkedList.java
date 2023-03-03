package linked_list;

/**
 * Description: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class DeleteTheMiddleNodeInLinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode prev = findPrevToMid(head);
        prev.next = prev.next.next;

        return head;
    }

    private ListNode findPrevToMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    private static class ListNode {
        ListNode next;
    }
}
