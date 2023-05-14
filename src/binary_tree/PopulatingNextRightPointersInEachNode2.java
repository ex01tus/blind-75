package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
 * Difficulty: Medium
 */
public class PopulatingNextRightPointersInEachNode2 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public Node connectViaLevelOrderTraversal(Node root) {
        if (root == null) return null;

        Queue<Node> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();
                if (i < levelSize - 1) current.next = planned.peek();

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }
        }

        return root;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public Node connect(Node root) {
        if (root == null) return null;

        Node dummyLeftmostOnTheNextLevel = new Node();
        Node prevOnTheNextLevel = dummyLeftmostOnTheNextLevel;
        Node current = root;

        while (current != null) {
            if (current.left != null) {
                prevOnTheNextLevel.next = current.left;
                prevOnTheNextLevel = current.left;
            }

            if (current.right != null) {
                prevOnTheNextLevel.next = current.right;
                prevOnTheNextLevel = current.right;
            }

            // move to the next node on the current level
            current = current.next;

            // go one level down
            if (current == null) {
                current = dummyLeftmostOnTheNextLevel.next;
                prevOnTheNextLevel = dummyLeftmostOnTheNextLevel;
                prevOnTheNextLevel.next = null;
            }
        }

        return root;
    }

    private static class Node {
        Node left;
        Node right;
        Node next;
    }
}
