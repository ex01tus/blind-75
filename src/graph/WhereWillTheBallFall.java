package graph;

/**
 * Description: https://leetcode.com/problems/water-and-jug-problem
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m)
 */
public class WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int ball = 0; ball < grid[0].length; ball++) {
            result[ball] = fallDown(0, ball, grid);
        }

        return result;
    }

    private int fallDown(int row, int col, int[][] grid) {
        if (row == grid.length) return col;

        if (grid[row][col] == 1
                && col < grid[0].length - 1
                && grid[row][col] == grid[row][col + 1]) {
            return fallDown(row + 1, col + 1, grid); // fall to the right
        } else if (grid[row][col] == -1
                && col > 0
                && grid[row][col] == grid[row][col - 1]) {
            return fallDown(row + 1, col - 1, grid); // fall to the left
        }

        return -1;
    }
}
