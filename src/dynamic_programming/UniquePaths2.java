package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/unique-paths-ii
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] grid) {
        // for some bizarre reason there's a test case with robot staying on an obstacle
        if (grid[0][0] == 1) return 0;

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;

                if (grid[i][j] == 1) { // obstacle -> no ways to reach this cell
                    dp[i][j] = 0;
                    continue;
                }

                int pathsFromTop = i > 0 ? dp[i - 1][j] : 0;
                int pathsFromLeft = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = pathsFromTop + pathsFromLeft;
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
