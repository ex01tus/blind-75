package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        boolean goLeft = true;

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            List<Integer> level = new LinkedList<>();
            result.add(level);

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();

                if (goLeft) {
                    level.add(current.val);
                } else {
                    level.add(0, current.val);
                }

                if (current.left != null) {
                    planned.offer(current.left);
                }

                if (current.right != null) {
                    planned.offer(current.right);
                }
            }

            goLeft = !goLeft; // reverse the direction
        }

        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
