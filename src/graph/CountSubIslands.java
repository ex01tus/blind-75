package graph;

/**
 * Description: https://leetcode.com/problems/count-sub-islands
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class CountSubIslands {

    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] visited = new int[grid2.length][grid2[0].length];
        int subIslands = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && visited[i][j] == 0 && isSubIsland(grid1, grid2, visited, i, j)) {
                    subIslands++;
                }
            }
        }

        return subIslands;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int[][] visited, int x, int y) {
        if (grid1[x][y] != 1) return false;

        visited[x][y] = 1;
        boolean isSubIsland = true;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < grid2.length && y1 >= 0 && y1 < grid2[0].length
                    && visited[x1][y1] == 0 && grid2[x1][y1] == 1) {
                if (!isSubIsland(grid1, grid2, visited, x1, y1)) {
                    isSubIsland = false;
                }
            }
        }

        return isSubIsland;
    }
}
