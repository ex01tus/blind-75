package linked_list;

/**
 * Description: https://leetcode.com/problems/remove-linked-list-elements
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = current;
            }

            current = current.next;
        }

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
