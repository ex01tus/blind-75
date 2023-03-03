package binary_tree;

/**
 * Description: https://leetcode.com/problems/univalued-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTreeWithHelperMethod(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;

        return isUnivalTree(root.left, val)
                && isUnivalTree(root.right, val);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.right != null && root.right.val != root.val) return false;
        if (root.left != null && root.left.val != root.val) return false;

        return isUnivalTree(root.right) && isUnivalTree(root.left);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
