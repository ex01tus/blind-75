package linked_list;

/**
 * Description: https://leetcode.com/problems/add-two-numbers
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode current = head;

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

        return head.next;
    }

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
