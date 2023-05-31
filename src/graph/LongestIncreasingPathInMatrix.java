package graph;

/**
 * Description: https://leetcode.com/problems/longest-increasing-path-in-a-matrix
 * Difficulty: Hard
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class LongestIncreasingPathInMatrix {

    private final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int longestPath = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int path = dfs(matrix, i, j, memo);
                longestPath = Math.max(longestPath, path);
            }
        }

        return longestPath;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] memo) {
        // we don't need to track visited nodes:
        // we'll never visit one node twice because of the always increasing condition
        // instead we can cache the results for each node to trim recursion tree
        if (memo[x][y] != 0) return memo[x][y];

        int path = 1;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < matrix.length && y1 >= 0 && y1 < matrix[0].length
                    && matrix[x1][y1] < matrix[x][y]) {
                path = Math.max(path, dfs(matrix, x1, y1, memo) + 1);
            }
        }

        memo[x][y] = path;
        return path;
    }
}
