package w2;

/**
 * Description: https://leetcode.com/problems/diameter-of-binary-tree
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return heightAndDiameter(root).diameter;
    }

    private Pair heightAndDiameter(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = heightAndDiameter(root.left);
        Pair right = heightAndDiameter(root.right);
        int diameter = left.height + right.height;

        int maxHeight = Math.max(left.height, right.height) + 1;
        int maxDiameter = Math.max(
                diameter,
                Math.max(left.diameter, right.diameter));

        return new Pair(maxHeight, maxDiameter);
    }

    private static class Pair {
        int height;
        int diameter;

        public Pair(int h, int d) {
            height = h;
            diameter = d;
        }
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
