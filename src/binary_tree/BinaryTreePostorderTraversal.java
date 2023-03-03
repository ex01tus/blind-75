package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-tree-postorder-traversal
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversalViaTwoStacks(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> postorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> out = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            out.push(current);

            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }

        while (!out.isEmpty()) {
            postorder.add(out.pop().val);
        }

        return postorder;
    }

    public List<Integer> postorderTraversalViaRecursion(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        traversePostorder(root, postorder);

        return postorder;
    }

    private void traversePostorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        traversePostorder(root.left, result);
        traversePostorder(root.right, result);
        result.add(root.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
