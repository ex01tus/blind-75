package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/trim-a-binary-search-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
