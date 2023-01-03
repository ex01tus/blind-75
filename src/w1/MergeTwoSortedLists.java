package w1;

/**
 * Description: https://leetcode.com/problems/merge-two-sorted-lists
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(m + n)
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            }
        }

        while (list1 != null) {
            current.next = list1;
            current = list1;
            list1 = list1.next;
        }

        while (list2 != null) {
            current.next = list2;
            current = list2;
            list2 = list2.next;
        }

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
