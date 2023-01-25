package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-tree-right-side-view
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            result.add(planned.peekLast().val);

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();

                if (current.left != null) {
                    planned.offer(current.left);
                }

                if (current.right != null) {
                    planned.offer(current.right);
                }
            }
        }

        return result;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
