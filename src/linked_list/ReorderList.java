package linked_list;

/**
 * Description: https://leetcode.com/problems/reorder-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        // no need to reorder list of size 0/1
        if (head == null || head.next == null) return;

        ListNode mid = findMiddleAndCut(head);
        ListNode tail = reverse(mid);
        merge(head, tail);
    }

    private ListNode findMiddleAndCut(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // remove mid element from the end of the first list
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private void merge(ListNode first, ListNode second) {
        while (first != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            if (firstNext == null) return;

            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private static class ListNode {
        ListNode next;
    }
}
