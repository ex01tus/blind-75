package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/flipping-an-image
 * Difficulty: Easy
 * Time complexity: O(n + m)
 * Space complexity: O(n + m)
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeaves = new ArrayList<>();
        findLeaves(root1, firstLeaves);
        List<Integer> secondLeaves = new ArrayList<>();
        findLeaves(root2, secondLeaves);

        return Objects.equals(firstLeaves, secondLeaves);
    }

    private void findLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
