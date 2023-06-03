package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/average-of-levels-in-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        List<Double> averages = new ArrayList<>();
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            long sum = 0L;
            int count = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                sum += current.val;
                count++;

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }

            double avg = (double) sum / count;
            averages.add(avg);
        }

        return averages;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
