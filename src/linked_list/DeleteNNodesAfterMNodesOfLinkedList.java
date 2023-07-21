package linked_list;

/**
 * Description: https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class DeleteNNodesAfterMNodesOfLinkedList {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode prev = head;

        int toKeep = m;
        int toSkip = n;
        while (current != null) {
            if (toKeep > 0) {
                prev = current;
                current = current.next;
                toKeep--;
            } else if (toSkip > 0) {
                prev.next = null;
                current = current.next;
                toSkip--;
            } else {
                prev.next = current;
                toKeep = m;
                toSkip = n;
            }
        }

        return head;
    }

    private static class ListNode {
        private ListNode next;
    }
}
