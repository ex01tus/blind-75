package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/binary-search-tree-iterator
 * Difficulty: Medium
 * Time complexity: O(1) on average for next(), O(1) for hasNext()
 * Space complexity: O(h)
 */
public class BinarySearchTreeIterator {

    private static class BSTIterator {

        private final Deque<TreeNode> stack;
        private TreeNode current;

        public BSTIterator(TreeNode root) {
            this.stack = new LinkedList<>();
            this.current = root;
        }

        public int next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            int val = current.val;
            current = current.right;

            return val;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        private static class TreeNode {
            private int val;
            private TreeNode left;
            private TreeNode right;
        }
    }
}
