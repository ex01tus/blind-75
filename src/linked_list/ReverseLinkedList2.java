package linked_list;

/**
 * Description: https://leetcode.com/problems/reverse-linked-list-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prevToReversed = dummy;
        for (int i = 0; i < left - 1; i++) {
            prevToReversed = prevToReversed.next;
        }

        prevToReversed.next = reverseNextN(prevToReversed.next, right - left + 1);

        return dummy.next;
    }

    private ListNode reverseNextN(ListNode head, int n) {
        ListNode reversedTail = head; // ([2] -> 3 -> 4) -> 5
        ListNode prev = null;         // reversed head
        for (int i = 0; i < n; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        reversedTail.next = head;     // (4 -> 3 -> [2]) -> 5

        return prev;                  // ([4] -> 3 -> 2) -> 5
    }

    private static class ListNode {
        ListNode next;
    }
}
