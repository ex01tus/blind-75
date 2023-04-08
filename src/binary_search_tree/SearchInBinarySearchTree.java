package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/search-in-a-binary-search-tree
 * Difficulty: Easy
 */
public class SearchInBinarySearchTree {

    /**
     * Time complexity: O(h)
     * Space complexity: O(1)
     */
    public TreeNode searchBSTViaIteration(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }

        return root;
    }

    /**
     * Time complexity: O(h)
     * Space complexity: O(h)
     */
    public TreeNode searchBSTViaRecursion(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val
                ? searchBSTViaRecursion(root.left, val)
                : searchBSTViaRecursion(root.right, val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
