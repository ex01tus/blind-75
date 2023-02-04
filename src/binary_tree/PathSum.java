package binary_tree;

/**
 * Description: https://leetcode.com/problems/path-sum
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int remains) {
        if (root == null) return false;

        remains -= root.val;
        if (root.left == null && root.right == null) {
            return remains == 0;
        }

        return hasPathSum(root.right, remains) || hasPathSum(root.left, remains);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
