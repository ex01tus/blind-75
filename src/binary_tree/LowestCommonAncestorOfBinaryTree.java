package binary_tree;

/**
 * Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == q.val || root.val == p.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
