package binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/path-sum-iii
 * Difficulty: Medium
 */
public class PathSum3 {

    public int pathSumViaMemoization(TreeNode root, int targetSum) {
        return pathSum(root, 0L, targetSum, new HashMap<>());
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private int pathSum(
            TreeNode root,
            long currentSum,
            int targetSum,
            Map<Long, Integer> prefixSumFrequencies) {
        if (root == null) return 0;

        currentSum += root.val;

        int currentPath = currentSum == targetSum ? 1 : 0;
        int previousPaths = prefixSumFrequencies.getOrDefault(currentSum - targetSum, 0);

        prefixSumFrequencies.merge(currentSum, 1, Integer::sum);

        int result = currentPath
                + previousPaths
                + pathSum(root.left, currentSum, targetSum, prefixSumFrequencies)
                + pathSum(root.right, currentSum, targetSum, prefixSumFrequencies);

        prefixSumFrequencies.merge(currentSum, -1, Integer::sum);

        return result;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(h)
     */
    public int pathSum(TreeNode root, int remains) {
        if (root == null) return 0;

        return pathSumStartingWith(root, remains)
                + pathSum(root.left, remains)
                + pathSum(root.right, remains);
    }

    private int pathSumStartingWith(TreeNode root, int remains) {
        if (root == null) return 0;

        return (remains == root.val ? 1 : 0)
                + pathSumStartingWith(root.left, remains - root.val)
                + pathSumStartingWith(root.right, remains - root.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
