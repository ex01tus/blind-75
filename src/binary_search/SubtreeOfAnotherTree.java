package binary_search;

/**
 * Description: https://leetcode.com/problems/subtree-of-another-tree
 * Difficulty: Easy
 * Time complexity: O(m * n)
 * Space complexity: O(h2)
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isEqual(root, subRoot)) return true;

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        return left || right;
    }

    private boolean isEqual(TreeNode first, TreeNode second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.val != second.val) return false;

        boolean left = isEqual(first.left, second.left);
        boolean right = isEqual(first.right, second.right);

        return left && right;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
