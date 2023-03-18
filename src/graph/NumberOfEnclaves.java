package graph;

/**
 * Description: https://leetcode.com/problems/number-of-enclaves
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class NumberOfEnclaves {

    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numEnclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            dfs(grid, visited, i, 0);
            dfs(grid, visited, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, visited, 0, i);
            dfs(grid, visited, grid.length - 1, i);
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int[][] visited, int x, int y) {
        if (grid[x][y] == 0) return;

        visited[x][y] = 1;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length
                    && visited[x1][y1] == 0) {
                dfs(grid, visited, x1, y1);
            }
        }
    }
}
