package linked_list;

/**
 * Description: https://leetcode.com/problems/merge-nodes-in-between-zeros
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MergeNodesInBetweenZeroes {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode merged = dummyHead;
        int currentSum = 0;

        while (head != null) {
            if (head.val == 0) {
                merged.next = new ListNode(currentSum);
                merged = merged.next;
                currentSum = 0;
            }

            currentSum += head.val;
            head = head.next;
        }

        // skip dummy and the first zero
        return dummyHead.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
