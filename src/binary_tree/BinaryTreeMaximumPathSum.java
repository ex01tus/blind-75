package binary_tree;

/**
 * Description: https://leetcode.com/problems/binary-tree-maximum-path-sum
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class BinaryTreeMaximumPathSum {

    private int max;

    public int maxPathSumWithGlobalVariable(TreeNode root) {
        max = root.val;
        findMaxPathWithoutSplit(root);
        return max;
    }

    private int findMaxPathWithoutSplit(TreeNode root) {
        if (root == null) return 0;

        // if the gain from the subtree is negative, there is no sense of adding it to the max path
        int leftGain = Math.max(0, findMaxPathWithoutSplit(root.left));
        int rightGain = Math.max(0, findMaxPathWithoutSplit(root.right));

        max = Math.max(max, root.val + leftGain + rightGain); // path with split (we can only split once)

        return root.val + Math.max(leftGain, rightGain); // path without a split
    }

    public int maxPathSumWithNoGlobalVariable(TreeNode root) {
        int[] max = new int[]{root.val}; // neat trick: pass array as a result accumulator
        findMaxPath(root, max);
        return max[0];
    }

    private int findMaxPath(TreeNode root, int[] max) {
        if (root == null) return 0;

        int maxLeft = Math.max(0, findMaxPath(root.left, max));
        int maxRight = Math.max(0, findMaxPath(root.right, max));
        max[0] = Math.max(max[0], root.val + maxLeft + maxRight);

        return root.val + Math.max(maxLeft, maxRight);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
