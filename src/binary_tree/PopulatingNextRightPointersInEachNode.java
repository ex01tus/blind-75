package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 * Difficulty: Medium
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public Node connectViaLevelOrderTraversal(Node root) {
        if (root == null) return root;

        Queue<Node> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            Node prev = null;
            int levelSize = planned.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();
                current.next = prev;
                prev = current;

                if (current.right != null) planned.offer(current.right);
                if (current.left != null) planned.offer(current.left);
            }
        }

        return root;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public Node connectWithNoExtraSpace(Node root) {
        if (root == null) return root;

        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }

                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            levelStart = levelStart.left;
        }

        return root;
    }

    private static class Node {
        Node left;
        Node right;
        Node next;
    }
}
