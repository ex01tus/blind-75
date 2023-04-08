package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/insert-into-a-binary-search-tree
 * Difficulty: Medium
 */
public class InsertIntoBinarySearchTree {

    /**
     * Time complexity: O(h)
     * Space complexity: O(1)
     */
    public TreeNode insertIntoBSTViaIteration(TreeNode root, int val) {
        TreeNode current = root;

        while (current != null) {
            if (current.val > val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    return root;
                }

                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    return root;
                }

                current = current.right;
            }
        }

        return new TreeNode(val);
    }

    /**
     * Time complexity: O(h)
     * Space complexity: O(h)
     */
    public TreeNode insertIntoBSTViaRecursion(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            root.left = insertIntoBSTViaRecursion(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBSTViaRecursion(root.right, val);
        }

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
