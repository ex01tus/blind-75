package linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/plus-one-lignked-list
 * Difficulty: Medium
 */
public class PlusOneLinkedList {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode plusOneOptimalApproach(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        ListNode nonNine = dummy;
        while (head != null) {
            if (head.val != 9) nonNine = head;
            head = head.next;
        }

        nonNine.val += 1;

        ListNode nine = nonNine.next;
        while (nine != null) {
            nine.val = 0;
            nine = nine.next;
        }

        return dummy.val == 0 ? dummy.next : dummy;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public ListNode plusOneViaStack(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        Deque<ListNode> stack = buildStack(dummy);

        int carry = 1;
        while (!stack.isEmpty()) {
            ListNode current = stack.pop();
            int sum = current.val + carry;
            current.val = sum % 10;
            carry = sum / 10;
        }

        return dummy.val == 0 ? dummy.next : dummy;
    }

    private Deque<ListNode> buildStack(ListNode dummy) {
        Deque<ListNode> stack = new LinkedList<>();

        ListNode current = dummy;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        return stack;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
