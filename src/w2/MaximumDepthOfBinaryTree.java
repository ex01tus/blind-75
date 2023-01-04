package w2;

/**
 * Description: https://leetcode.com/problems/maximum-depth-of-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;

        return Math.max(depth(root.left, depth), depth(root.right, depth));
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
