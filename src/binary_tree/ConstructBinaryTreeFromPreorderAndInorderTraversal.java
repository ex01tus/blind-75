package binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> inorderValueToIndexMap;
    private int rootIndexInPreorderArray;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootIndexInPreorderArray = 0;
        inorderValueToIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderValueToIndexMap.put(inorder[i], i);
        }

        return toTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode toTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode();
        root.val = preorder[rootIndexInPreorderArray++];
        int rootIndexInInorderArray = inorderValueToIndexMap.get(root.val);

        root.left = toTree(preorder, left, rootIndexInInorderArray - 1);
        root.right = toTree(preorder, rootIndexInInorderArray + 1, right);

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
