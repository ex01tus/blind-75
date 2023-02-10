package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:https://leetcode.com/problems/binary-tree-preorder-traversal
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversalViaIteration(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                preorder.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return preorder;
    }

    public List<Integer> preorderTraversalViaRecursion(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traversePreorder(root, preorder);

        return preorder;
    }

    private void traversePreorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        traversePreorder(root.left, result);
        traversePreorder(root.right, result);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
