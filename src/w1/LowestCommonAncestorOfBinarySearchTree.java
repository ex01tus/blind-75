package w1;

/**
 * Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * Difficulty: Medium
 * Time complexity: O(log n)
 * Space complexity: O(log n)
 */
public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val > root.val && q.val < root.val)
                || (p.val < root.val && q.val > root.val)) {
            return root;
        }

        if (p.val == root.val) {
            return p;
        }

        if (q.val == root.val) {
            return q;
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        throw new RuntimeException();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
