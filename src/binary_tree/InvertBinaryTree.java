package binary_tree;

/**
 * Description: https://leetcode.com/problems/invert-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invert(root.left);
        invert(root.right);
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
