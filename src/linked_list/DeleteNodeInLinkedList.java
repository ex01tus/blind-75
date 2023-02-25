package linked_list;

/**
 * Description: https://leetcode.com/problems/delete-node-in-a-linked-list
 * Difficulty: Medium
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
