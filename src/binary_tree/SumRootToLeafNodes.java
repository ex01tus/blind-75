package binary_tree;

/**
 * Description: https://leetcode.com/problems/sum-root-to-leaf-numbers
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class SumRootToLeafNodes {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int sum) {
        if (root == null) return 0;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return sum(root.left, sum) + sum(root.right, sum);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
