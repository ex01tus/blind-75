package linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/palindrome-linked-list
 * Difficulty: Easy
 */
public class PalindromeLinkedList {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isPalindromeViaStack(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { // in case of odd nodes number
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }

        return true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean isPalindromeViaListReversal(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle);

        return isEqual(head, second);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

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

    private boolean isEqual(ListNode first, ListNode second) {
        while (second != null) {
            if (first.val != second.val) return false;

            first = first.next;
            second = second.next;
        }

        return true;
    }

    private static class ListNode {
        ListNode next;
        int val;
    }
}
