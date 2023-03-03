package linked_list;

/**
 * Description: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumTwinSumOfLinkedList {

    public int pairSum(ListNode head) {
        ListNode mid = findMid(head);
        ListNode second = reverse(mid);

        return maxPairSum(head, second);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
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

    private int maxPairSum(ListNode first, ListNode second) {
        int max = 0;
        while (first != null && second != null) {
            max = Math.max(max, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return max;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
