package binary_tree;

/**
 * Description: https://leetcode.com/problems/maximum-depth-of-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
