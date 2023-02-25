package linked_list;

/**
 * Description: https://leetcode.com/problems/sort-list
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(log n)
 */
public class SortList {

    public ListNode sortListViaMergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = sortListViaMergeSort(head);
        ListNode right = sortListViaMergeSort(mid);

        return merge(left, right);
    }

    private ListNode findMid(ListNode root) {
        ListNode prev = null;
        ListNode slow = root;
        ListNode fast = root;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return slow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }

            current = current.next;
        }

        current.next = first != null ? first : second;

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
