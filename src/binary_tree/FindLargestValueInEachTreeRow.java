package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/transpose-matrix
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> maxValues = new ArrayList<>();

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                max = Math.max(max, current.val);

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }

            maxValues.add(max);
        }

        return maxValues;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
