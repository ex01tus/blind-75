package linked_list;

/**
 * Description: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list
 * Difficulty: Medium
 * Time complexity: O(n * log v)
 * Space complexity: O(1)
 */
public class InsertGreatestCommonDivisorsInLinkedList {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            int gcd = findGCDViaEuclidAlgo(current.val, current.next.val);

            ListNode next = current.next;
            current.next = new ListNode(gcd, next);

            current = next;
        }

        return head;
    }

    private int findGCDViaEuclidAlgo(int a, int b) {
        if (b == 0) return a;
        return findGCDViaEuclidAlgo(b, a % b);
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
