package quad_tree;

/**
 * Description: https://leetcode.com/problems/construct-quad-tree
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(log n)
 */
public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int x, int y, int length) {
        if (length == 1) {
            // single cell is always a leaf
            return new Node(grid[x][y] == 1, true);
        }

        Node topLeft = construct(grid, x, y, length / 2);
        Node topRight = construct(grid, x, y + length / 2, length / 2);
        Node bottomLeft = construct(grid, x + length / 2, y, length / 2);
        Node bottomRight = construct(grid, x + length / 2, y + length / 2, length / 2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val
                && bottomLeft.val == bottomRight.val
                && topLeft.val == bottomLeft.val) {
            // all children are leaves with the same value -> root is leaf
            return new Node(topLeft.val, true);
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private static class Node {

        private final boolean val;
        private final boolean isLeaf;
        private final Node topLeft;
        private final Node topRight;
        private final Node bottomLeft;
        private final Node bottomRight;

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
