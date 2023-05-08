package linked_list;

/**
 * Description: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                // skip duplicates
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // don't update prev pointer
                prev.next = head.next;
            } else {
                // move prev pointer forward
                prev = head;
            }

            head = head.next;
        }

        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
