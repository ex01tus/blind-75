package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/n-ary-tree-level-order-traversal
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;

        Queue<Node> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            List<Integer> level = new ArrayList<>();
            traversal.add(level);

            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();
                level.add(current.val);

                for (Node child : current.children) {
                    planned.offer(child);
                }
            }
        }

        return traversal;
    }

    private static class Node {
        int val;
        List<Node> children;
    }
}
