package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/copy-list-with-random-pointer
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Node> originalToCopyMap = new HashMap<>();

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            originalToCopyMap.put(current, copy);

            current = current.next;
        }

        Node dummy = new Node(-1);
        current = dummy;
        while (head != null) {
            current.next = originalToCopyMap.get(head);
            current.next.next = originalToCopyMap.get(head.next);
            current.next.random = originalToCopyMap.get(head.random);

            head = head.next;
            current = current.next;
        }

        return dummy.next;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }
}
