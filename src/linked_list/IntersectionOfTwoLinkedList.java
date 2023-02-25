package linked_list;

/**
 * Description: https://leetcode.com/problems/intersection-of-two-linked-lists
 * Difficulty: Easy
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 */
public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNodeWithMultipleLoops(ListNode first, ListNode second) {
        int firstLength = length(first);
        int secondLength = length(second);

        while (firstLength > secondLength) {
            first = first.next;
            firstLength--;
        }

        while (secondLength > firstLength) {
            second = second.next;
            secondLength--;
        }

        while (first != second) { // until intersection or null
            first = first.next;
            second = second.next;
        }

        return first;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }

    public ListNode getIntersectionNodeWithSingleLoop(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }

        return a;
    }

    private static class ListNode {
        ListNode next;
    }
}
