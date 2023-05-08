package binary_search_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/two-sum-bsts
 * Difficulty: Medium
 */
public class TwoSumBSTs {

    /**
     * Time complexity: O(m * log h2)
     * Space complexity: O(h1 + h2)
     */
    public boolean twoSumBSTsViaBinaryTreeSearch(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) return false;
        if (isExist(root2, target - root1.val)) return true;

        return twoSumBSTsViaBinaryTreeSearch(root1.left, root2, target)
                || twoSumBSTsViaBinaryTreeSearch(root1.right, root2, target);
    }

    private boolean isExist(TreeNode root, int target) {
        if (root == null) return false;

        if (root.val > target) return isExist(root.left, target);
        if (root.val < target) return isExist(root.right, target);

        return true;
    }

    /**
     * Time complexity: O(m + n)
     * Space complexity: O(m + n)
     */
    public boolean twoSumBSTsViaInorderTraversal(TreeNode root1, TreeNode root2, int target) {
        List<Integer> inorder1 = inorderTraversal(root1);
        List<Integer> inorder2 = inorderTraversal(root2);

        int p1 = 0;
        int p2 = inorder2.size() - 1;

        while (p1 < inorder1.size() && p2 >= 0) {
            int val1 = inorder1.get(p1);
            int val2 = inorder2.get(p2);

            if (val1 + val2 > target) {
                p2--;
            } else if (val1 + val2 < target) {
                p1++;
            } else {
                return true;
            }
        }

        return false;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                inorder.add(root.val);
                root = root.right;
            }
        }

        return inorder;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
