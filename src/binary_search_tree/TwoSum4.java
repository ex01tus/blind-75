package binary_search_tree;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/two-sum-iv-input-is-a-bst
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class TwoSum4 {

    public boolean findTargetViaInorderTraversal(TreeNode root, int k) {
        List<Integer> inorder = inorderTraversal(root); // inorder traversal of a BST is a sorted array
        return isTargetExist(inorder, k);
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

    private boolean isTargetExist(List<Integer> inorder, int target) {
        int left = 0;
        int right = inorder.size() - 1;

        while (left < right) {
            int sum = inorder.get(left) + inorder.get(right);

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean findTargetViaRecursion(TreeNode root, int k) {
        return isTargetExist(root, k, new HashSet<>());
    }

    private boolean isTargetExist(TreeNode root, int target, Set<Integer> seen) {
        if (root == null) return false;
        if (seen.contains(target - root.val)) return true;

        seen.add(root.val);
        return isTargetExist(root.left, target, seen)
                || isTargetExist(root.right, target, seen);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
