package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/check-completeness-of-a-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CheckCompletenessOfBinaryTree {

    public boolean isCompleteTreeViaGapDetection(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        TreeNode prev = root;
        while (!planned.isEmpty()) {
            TreeNode current = planned.poll();

            if (current != null) {
                if (prev == null) return false;
                planned.offer(current.left);
                planned.offer(current.right);
            }

            prev = current;
        }

        return true;
    }

    public boolean isCompleteTreeViaNullNodeDetection(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        boolean isNullNodeFound = false;
        while (!planned.isEmpty()) {
            TreeNode current = planned.poll();

            if (current == null) {
                isNullNodeFound = true;
            } else {
                if (isNullNodeFound) return false;
                planned.offer(current.left);
                planned.offer(current.right);
            }
        }

        return true;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
