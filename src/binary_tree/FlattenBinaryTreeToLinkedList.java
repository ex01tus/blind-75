package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FlattenBinaryTreeToLinkedList {

    public void flattenViaReversedPostorderTraversal(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

            if (!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }
    }

    public void flattenViaPreorderTraversal(TreeNode root) {
        List<TreeNode> preorder = traversePreorder(root);
        for (int i = 0; i < preorder.size() - 1; i++) {
            TreeNode current = preorder.get(i);
            current.left = null;
            current.right = preorder.get(i + 1);
        }
    }

    private List<TreeNode> traversePreorder(TreeNode root) {
        List<TreeNode> preorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                preorder.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return preorder;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
