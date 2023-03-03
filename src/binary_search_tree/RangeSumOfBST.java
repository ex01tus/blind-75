package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/range-sum-of-bst
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class RangeSumOfBST {

    public int rangeSumBSTWithExtraVariable(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) return rangeSumBST(root.right, low, high); // traverse right branch
        if (root.val > high) return rangeSumBST(root.left, low, high); // traverse left branch

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
