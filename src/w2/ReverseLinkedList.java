package w2;

/**
 * Description: https://leetcode.com/problems/reverse-linked-list
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private static class ListNode {
        ListNode next;
    }
}
