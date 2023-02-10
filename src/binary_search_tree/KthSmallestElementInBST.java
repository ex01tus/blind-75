package binary_search_tree;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/kth-smallest-element-in-a-bst
 * Difficulty: Medium
 */
public class KthSmallestElementInBST {

    /**
     * Time complexity: O(h + k)
     * Space complexity: O(h)
     */
    public int kthSmallestViaIterativeInorderTraversal(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
        }

        return -1;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int kthSmallestViaRecursiveInorderTraversal(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        traverseInorder(root, inorder);

        return inorder.get(k - 1);
    }

    private void traverseInorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        traverseInorder(root.left, result);
        result.add(root.val);
        traverseInorder(root.right, result);
    }

    /**
     * Time complexity: O(nlog k)
     * Space complexity: O(h + k)
     */
    public int kthSmallestViaMaxHeap(TreeNode root, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        backtrack(root, maxHeap, k);

        return maxHeap.peek();
    }

    private void backtrack(TreeNode root, Queue<Integer> maxHeap, int k) {
        if (root == null) return;

        maxHeap.offer(root.val);
        if (maxHeap.size() > k) maxHeap.poll();

        backtrack(root.left, maxHeap, k);
        backtrack(root.right, maxHeap, k);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
