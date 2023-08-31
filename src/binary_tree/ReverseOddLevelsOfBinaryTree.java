package binary_tree;

import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ReverseOddLevelsOfBinaryTree {

    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> planned = new LinkedList<>();
        planned.offer(root);

        int level = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();

                if (current.left != null) planned.offer(current.left);
                if (current.right != null) planned.offer(current.right);
            }

            level++;

            if (level % 2 != 0) {
                reverseLevel(planned);
            }
        }

        return root;
    }

    private void reverseLevel(LinkedList<TreeNode> planned) {
        int left = 0;
        int right = planned.size() - 1;

        while (left < right) {
            swap(planned.get(left), planned.get(right));

            left++;
            right--;
        }
    }

    private void swap(TreeNode first, TreeNode second) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
