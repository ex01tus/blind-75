package linked_list;

/**
 * Description: https://leetcode.com/problems/rotate-list
 * Difficulty: Medium
 */
public class RotateList {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode rotateRightOptimalApproach(ListNode head, int rotations) {
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        int length = 1;
        while (fast.next != null) {
            fast = fast.next; // fast is now in the original list tail
            length++;
        }

        rotations = rotations % length;
        if (rotations == 0) return head;

        for (int i = 0; i < length - 1 - rotations; i++) {
            slow = slow.next; // slow is now in the new list tail
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    /**
     * Time complexity: O(n + k)
     * Space complexity: O(1)
     */
    public ListNode rotateRightNaiveApproach(ListNode head, int rotations) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < rotations; i++) {
            fast = fast.next;
            if (fast == null) fast = head;
        }

        if (fast == head) return head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    private static class ListNode {
        ListNode next;
    }
}
