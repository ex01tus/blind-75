package linked_list;

/**
 * Description: https://leetcode.com/problems/partition-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode();
        ListNode left = dummyLeft;
        ListNode dummyRight = new ListNode();
        ListNode right = dummyRight;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }

            head = head.next;
        }

        right.next = null;
        left.next = dummyRight.next;
        return dummyLeft.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
