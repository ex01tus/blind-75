package binary_tree;

/**
 * Description: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int current) {
        if (root == null) return 0;

        current = current * 2 + root.val;
        if (root.left == null && root.right == null) return current;

        return sum(root.left, current) + sum(root.right, current);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
