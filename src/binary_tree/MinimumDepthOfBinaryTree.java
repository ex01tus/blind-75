package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/minimum-depth-of-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumDepthOfBinaryTree {

    public int minDepthViaBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        int level = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            level++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                if (current.left == null && current.right == null) return level;
                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }
        }

        return -1;
    }

    public int minDepthViaRecursiveDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepthViaRecursiveDFS(root.right) + 1;
        if (root.right == null) return minDepthViaRecursiveDFS(root.left) + 1;

        return Math.min(minDepthViaRecursiveDFS(root.left), minDepthViaRecursiveDFS(root.right)) + 1;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
