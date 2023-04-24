package binary_tree;

/**
 * Description: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestZigZagPathInBinaryTree {

    private int maxPath;

    public int longestZigZagWithGlobalVariable(TreeNode root) {
        maxPath = 0;
        dfsWithGlobalVariable(root, true, 0);
        return maxPath;
    }

    private void dfsWithGlobalVariable(TreeNode root, boolean goLeft, int steps) {
        if (root == null) return;

        maxPath = Math.max(maxPath, steps);
        if (goLeft) {
            dfsWithGlobalVariable(root.left, false, steps + 1);
            dfsWithGlobalVariable(root.right, true, 1);
        } else {
            dfsWithGlobalVariable(root.right, true, steps + 1);
            dfsWithGlobalVariable(root.left, false, 1);
        }
    }

    public int longestZigZagWithoutGlobalVariable(TreeNode root) {
        return Math.max(
                dfs(root.left, false, 0),
                dfs(root.right, true, 0));
    }

    private int dfs(TreeNode root, boolean goLeft, int steps) {
        if (root == null) return steps;

        return goLeft
                ? Math.max(dfs(root.left, false, steps + 1), dfs(root.right, true, 0))
                : Math.max(dfs(root.right, true, steps + 1), dfs(root.left, false, 0));
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
