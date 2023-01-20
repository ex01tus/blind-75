package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-tree-level-order-traversal
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
