package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/maximal-square
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int largestSide = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '1') continue;

                int left = j > 0 ? dp[i][j - 1] : 0;
                int top = i > 0 ? dp[i - 1][j] : 0;
                int diag = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;

                // side of the largest square with the bottom right corner in matrix[i][j]
                dp[i][j] = Math.min(diag, Math.min(left, top)) + 1;
                largestSide = Math.max(largestSide, dp[i][j]);
            }
        }

        return largestSide * largestSide;
    }
}
