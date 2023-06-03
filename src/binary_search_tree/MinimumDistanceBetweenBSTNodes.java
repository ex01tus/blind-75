package binary_search_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/minimum-distance-between-bst-nodes
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int minDiff = Integer.MAX_VALUE;

        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev != null) minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
                prev = root;
                root = root.right;
            }
        }

        return minDiff;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
