package binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private Map<Integer, Integer> inorderValueToIndex;
    private int postorderRootIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderValueToIndex = toMap(inorder);
        postorderRootIndex = postorder.length - 1;
        return toTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode toTree(
            int[] postorder,
            int left,
            int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode();
        root.val = postorder[postorderRootIndex--];
        int inorderRootIndex = inorderValueToIndex.get(root.val);

        // right before left!
        root.right = toTree(postorder, inorderRootIndex + 1, right);
        root.left = toTree(postorder, left, inorderRootIndex - 1);

        return root;
    }

    private Map<Integer, Integer> toMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return map;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
