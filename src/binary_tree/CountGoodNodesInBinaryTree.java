package binary_tree;

/**
 * Description: https://leetcode.com/problems/count-good-nodes-in-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    private int count(TreeNode root, int max) {
        if (root == null) return 0;

        max = Math.max(root.val, max);

        int current = root.val >= max ? 1 : 0;
        int left = count(root.left, max);
        int right = count(root.right, max);

        return current + left + right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
