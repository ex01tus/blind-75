package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/minimum-path-sum
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int fromTop = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                int fromLeft = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(fromTop, fromLeft) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
