package graph;

/**
 * Description: https://leetcode.com/problems/number-of-closed-islands
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class NumberOfClosedIslands {

    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int closedIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0 && isClosed(grid, visited, i, j)) {
                    closedIslands++;
                }
            }
        }

        return closedIslands;
    }

    private boolean isClosed(int[][] grid, int[][] visited, int x, int y) {
        if (grid[x][y] == 1 || visited[x][y] == 1) {
            return true;
        }

        visited[x][y] = 1;
        boolean isClosed = true;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length
                    || !isClosed(grid, visited, x1, y1)) {
                isClosed = false;
            }
        }

        return isClosed;
    }
}
