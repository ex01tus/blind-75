package linked_list;

/**
 * Description: https://leetcode.com/problems/merge-two-sorted-lists
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(m + n)
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }

            current = current.next;
        }

        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
