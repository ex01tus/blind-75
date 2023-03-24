package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/binary-tree-level-order-traversal
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderViaIteration(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            result.add(level);

            int levelSize = planned.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                level.add(current.val);

                if (current.left != null) {
                    planned.offer(current.left);
                }

                if (current.right != null) {
                    planned.offer(current.right);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> levelOrderViaRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;

        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        List<Integer> currentLevel = result.get(level);
        currentLevel.add(root.val);

        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
