package linked_list;

/**
 * Description: https://leetcode.com/problems/middle-of-the-linked-list
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static class ListNode  {
        ListNode next;
    }
}
