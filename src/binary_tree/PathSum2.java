package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/path-sum-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, new ArrayList<>(), targetSum, paths);
        return paths;
    }

    private void pathSum(
            TreeNode root,
            List<Integer> currentPath,
            int remains,
            List<List<Integer>> paths) {
        if (root == null) return;

        currentPath.add(root.val);

        if (root.left == null && root.right == null && remains == root.val) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            pathSum(root.left, currentPath, remains - root.val, paths);
            pathSum(root.right, currentPath, remains - root.val, paths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
