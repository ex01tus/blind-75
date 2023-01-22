package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/validate-binary-search-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
