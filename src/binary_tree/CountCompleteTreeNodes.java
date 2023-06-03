package binary_tree;

/**
 * Description: https://leetcode.com/problems/count-complete-tree-nodes
 * Difficulty: Medium
 */
public class CountCompleteTreeNodes {

    /**
     * Time complexity: O(log n * log n)
     * Space complexity: O(1)
     */
    public int countNodesViaBinarySearch(TreeNode root) {
        if (root == null) return 0;

        int depth = findDepth(root);
        int lastLevelNodesNumber = findLastLevelNodesNumber(root, depth);

        return (int) Math.pow(2, depth) - 1 + lastLevelNodesNumber;
    }

    private int findLastLevelNodesNumber(TreeNode root, int depth) {
        // last level has from 1 to 2^depth nodes
        int left = 0;
        int right = (int) Math.pow(2, depth) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isExist(root, depth, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean isExist(TreeNode root, int depth, int idx) {
        // use BS to reconstruct the sequence of moves from root to idx node
        int left = 0;
        int right = (int) Math.pow(2, depth) - 1;

        for (int i = 0; i < depth; i++) {
            int mid = left + (right - left) / 2;
            if (idx <= mid) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }
        }

        return root != null;
    }

    private int findDepth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(h)
     */
    public int countNodesNaiveApproach(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodesNaiveApproach(root.left) + countNodesNaiveApproach(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
