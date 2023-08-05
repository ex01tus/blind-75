package binary_tree;

/**
 * Description: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
        return findLongestConsecutivePath(root, Integer.MIN_VALUE, 0);
    }

    private int findLongestConsecutivePath(TreeNode root, int prev, int path) {
        if (root == null) return path;

        path = (root.val == prev + 1) ? path + 1 : 1;

        int left = findLongestConsecutivePath(root.left, root.val, path);
        int right = findLongestConsecutivePath(root.right, root.val, path);

        return Math.max(path, Math.max(left, right));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
