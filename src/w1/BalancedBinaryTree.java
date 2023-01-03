package w1;

/**
 * Description: https://leetcode.com/problems/balanced-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root, 0) != -1;
    }

    private int height(TreeNode root, int height) {
        if (root == null) return height;

        height++;

        int left = height(root.left, height);
        int right = height(root.right, height);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right);
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
