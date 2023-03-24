package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> traversal = new LinkedList<>();

        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();
                level.add(current.val);

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }

            traversal.add(0, level);
        }

        return traversal;
    }

    private static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }
}
