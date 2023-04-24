package linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/add-two-numbers-ii
 * Difficulty: Medium
 */
public class AddTwoNumbers2 {

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(max(n, m))
     */
    public ListNode addTwoNumbersViaReversal(ListNode l1, ListNode l2) {
        ListNode first = reverse(l1);
        ListNode second = reverse(l2);

        ListNode sum = sum(first, second);
        return reverse(sum);
    }

    private ListNode sum(ListNode first, ListNode second) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        int carry = 0;
        while (first != null || second != null) {
            int sum = carry;
            if (first != null) {
                sum += first.val;
                first = first.next;
            }

            if (second != null) {
                sum += second.val;
                second = second.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
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

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(n + m)
     */
    public ListNode addTwoNumbersViaStack(ListNode l1, ListNode l2) {
        Deque<Integer> first = toStack(l1);
        Deque<Integer> second = toStack(l2);

        ListNode sum = sum(first, second);
        return reverse(sum);
    }

    private ListNode sum(Deque<Integer> first, Deque<Integer> second) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        int carry = 0;
        while (!first.isEmpty() || !second.isEmpty()) {
            int sum = carry;
            if (!first.isEmpty()) sum += first.pop();
            if (!second.isEmpty()) sum += second.pop();

            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    private Deque<Integer> toStack(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        return stack;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
