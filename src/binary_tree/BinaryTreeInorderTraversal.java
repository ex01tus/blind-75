package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:https://leetcode.com/problems/binary-tree-inorder-traversal
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversalViaIteration(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                inorder.add(root.val);
                root = root.right;
            }
        }

        return inorder;
    }

    public List<Integer> inorderTraversalViaRecursion(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        traverseInorder(root, inorder);

        return inorder;
    }

    private void traverseInorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        traverseInorder(root.left, result);
        result.add(root.val);
        traverseInorder(root.right, result);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
