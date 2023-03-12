package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/unique-paths
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue; // not to override dp[0][0] with 0
                int pathsFromTop = i > 0 ? dp[i - 1][j] : 0;
                int pathsFromLeft = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = pathsFromTop + pathsFromLeft;
            }
        }

        return dp[m - 1][n - 1];
    }
}
