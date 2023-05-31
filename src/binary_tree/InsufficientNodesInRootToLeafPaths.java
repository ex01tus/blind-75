package binary_tree;

/**
 * Description: https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class InsufficientNodesInRootToLeafPaths {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return removeInsufficientNodes(root, 0, limit);
    }

    private TreeNode removeInsufficientNodes(TreeNode root, int currentPathSum, int limit) {
        if (root == null) return null;

        if (isLeaf(root)) {
            // remove insufficient leaf
            return currentPathSum + root.val >= limit ? root : null;
        }

        root.left = removeInsufficientNodes(root.left, currentPathSum + root.val, limit);
        root.right = removeInsufficientNodes(root.right, currentPathSum + root.val, limit);

        // if node became a leaf -> all the paths through it were insufficient -> remove it
        return isLeaf(root) ? null : root;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
