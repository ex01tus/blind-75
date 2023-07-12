package binary_tree;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/closest-leaf-in-a-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ClosestLeafInBinaryTree {

    private Map<TreeNode, TreeNode> nodeToParentMap;

    public int findClosestLeaf(TreeNode root, int target) {
        nodeToParentMap = new HashMap<>();
        findParents(root, null);

        TreeNode start = findStart(target);
        return findClosestLeaf(start);
    }

    private int findClosestLeaf(TreeNode start) {
        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(start);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(start);

        while (!planned.isEmpty()) {
            TreeNode current = planned.poll();
            if (current.left == null && current.right == null) return current.val;

            if (current.left != null && visited.add(current.left)) {
                planned.offer(current.left);
            }

            if (current.right != null && visited.add(current.right)) {
                planned.offer(current.right);
            }

            TreeNode parent = nodeToParentMap.get(current);
            if (parent != null && visited.add(parent)) {
                planned.offer(parent);
            }
        }

        return -1;
    }

    private TreeNode findStart(int target) {
        for (TreeNode node : nodeToParentMap.keySet()) {
            if (node.val == target) return node;
        }

        throw new RuntimeException();
    }

    private void findParents(TreeNode root, TreeNode parent) {
        if (root == null) return;

        nodeToParentMap.put(root, parent);
        findParents(root.left, root);
        findParents(root.right, root);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
