package binary_tree;

/**
 * Description: https://leetcode.com/problems/same-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
