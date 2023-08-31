package binary_tree;

/**
 * Description: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class SumOfNodesWithEvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        return sum(null, null, root);
    }

    private int sum(TreeNode grandParent, TreeNode parent, TreeNode current) {
        if (current == null) return 0;

        int sum = (grandParent != null && grandParent.val % 2 == 0) ? current.val : 0;
        return sum
                + sum(parent, current, current.left)
                + sum(parent, current, current.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
