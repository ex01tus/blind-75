package binary_search_tree;

/**
 * Description: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(log n)
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, left, mid - 1);
        root.right = toBST(nums, mid + 1, right);

        return root;
    }

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
