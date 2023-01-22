package binary_tree;

/**
 * Description: https://leetcode.com/problems/symmetric-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(log n)
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
