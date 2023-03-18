package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/inorder-successor-in-bst
 * Difficulty: Medium
 */
public class InorderSuccessorInBST {

    /**
     * Time complexity: O(h)
     * Space complexity: O(1)
     */
    public TreeNode inorderSuccessorViaIteration(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    /**
     * Time complexity: O(h)
     * Space complexity: O(h)
     */
    public TreeNode inorderSuccessorViaRecursion(TreeNode root, TreeNode p) {
        return find(root, null, p);
    }

    private TreeNode find(TreeNode current, TreeNode parent, TreeNode p) {
        if (current == null) return parent;

        return p.val >= current.val
                ? find(current.right, parent, p)
                : find(current.left, current, p);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
