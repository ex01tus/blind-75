package linked_list;

/**
 * Description: https://leetcode.com/problems/remove-duplicates-from-sorted-list
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
