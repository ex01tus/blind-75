package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/delete-node-in-a-bst
 * Difficulty: Medium
 * Time complexity: O(h)
 * Space complexity: O(h)
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            // delete in the left subtree
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // delete in the right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // delete current
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // take one step to the right and go all the way to the left to find successor
            TreeNode successorParent = root;
            TreeNode successor = root.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (successor == root.right) {
                successor.left = root.left;
                return successor;
            }

            successorParent.left = successor.right;
            successor.left = root.left;
            successor.right = root.right;
            return successor;
        }

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
