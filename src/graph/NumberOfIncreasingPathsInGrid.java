package graph;

/**
 * Description: https://leetcode.com/problems/number-of-increasing-paths-in-a-grid
 * Difficulty: Hard
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class NumberOfIncreasingPathsInGrid {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int countPaths(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += dfs(grid, cache, i, j);
                count %= MOD;
            }
        }

        return count;
    }

    private int dfs(int[][] grid, int[][] cache, int x, int y) {
        if (cache[x][y] != 0) return cache[x][y];

        int count = 1;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length
                    && grid[x1][y1] < grid[x][y]) {
                count += dfs(grid, cache, x1, y1);
                count %= MOD;
            }
        }

        cache[x][y] = count;
        return count;
    }
}
