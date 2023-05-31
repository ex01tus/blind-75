package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int currentLevel = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            int levelSum = 0;
            currentLevel++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                levelSum += current.val;

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
        }

        return maxLevel;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
