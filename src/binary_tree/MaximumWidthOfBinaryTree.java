package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/maximum-width-of-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;

        Deque<Pair> planned = new LinkedList<>();
        planned.offer(new Pair(root, 0));

        while (!planned.isEmpty()) {
            int levelSize = planned.size();

            int levelWidth = planned.peekLast().pos - planned.peekFirst().pos + 1;
            maxWidth = Math.max(levelWidth, maxWidth);

            for (int i = 0; i < levelSize; i++) {
                Pair current = planned.poll();

                if (current.node.left != null) {
                    planned.offer(new Pair(current.node.left, current.pos * 2));
                }

                if (current.node.right != null) {
                    planned.offer(new Pair(current.node.right, current.pos * 2 + 1));
                }
            }
        }

        return maxWidth;
    }

    private static class Pair {
        TreeNode node;
        int pos;

        public Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
