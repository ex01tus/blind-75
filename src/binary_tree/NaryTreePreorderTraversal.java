package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/n-ary-tree-preorder-traversal
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NaryTreePreorderTraversal {

    public List<Integer> preorderViaIteration(Node root) {
        if (root == null) return List.of();

        List<Integer> preorder = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);

        // dfs
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            preorder.add(current.val);

            // children are presented in level-order from left to right
            // -> have to reverse them because of the stack usage
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }

        return preorder;
    }

    public List<Integer> preorderViaRecursion(Node root) {
        List<Integer> preorder = new ArrayList<>();
        preorder(root, preorder);

        return preorder;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        for (Node child : root.children) {
            preorder(child, result);
        }
    }

    private static class Node {
        int val;
        List<Node> children;
    }
}
