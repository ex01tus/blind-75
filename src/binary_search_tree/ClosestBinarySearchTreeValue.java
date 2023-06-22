package binary_search_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/closest-binary-search-tree-value
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ClosestBinarySearchTreeValue {

    public int closestValueViaInorderTraversal(TreeNode root, double target) {
        int predecessor = Integer.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (predecessor <= target && target <= root.val) {
                    return Math.abs(predecessor - target) <= Math.abs(root.val - target) ? predecessor : root.val;
                }

                predecessor = root.val;
                root = root.right;
            }
        }

        return predecessor;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
