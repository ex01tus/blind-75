package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/deepest-leaves-sum
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        int levelSum = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                levelSum += current.val;

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }
        }

        return levelSum;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
