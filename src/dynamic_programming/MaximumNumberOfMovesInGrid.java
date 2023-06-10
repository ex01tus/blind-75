package dynamic_programming;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-moves-in-a-grid
 * Difficulty: Medium
 */
public class MaximumNumberOfMovesInGrid {

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     */
    public int maxMovesViaDP(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int col = grid[0].length - 2; col >= 0; col--) {
            for (int row = 0; row < grid.length; row++) {
                int current = grid[row][col];
                int toTop = row > 0 && grid[row - 1][col + 1] > current ? dp[row - 1][col + 1] + 1 : 0;
                int toBottom = row < grid.length - 1 && grid[row + 1][col + 1] > current ? dp[row + 1][col + 1] + 1 : 0;
                int toRight = grid[row][col + 1] > current ? dp[row][col + 1] + 1 : 0;

                dp[row][col] = Math.max(toRight, Math.max(toTop, toBottom));
            }
        }

        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            max = Math.max(max, dp[row][0]);
        }

        return max;
    }


    /**
     * Time complexity: O(m * m * n)
     * Space complexity: O(n)
     */
    public int maxMovesViaBFS(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            max = Math.max(max, findPath(grid, row));
            if (max == grid[0].length) return max;
        }

        return max;
    }

    private final int[][] directions = new int[][]{{-1, 1}, {0, 1}, {1, 1}};

    private int findPath(int[][] grid, int row) {
        int[][] visited = new int[grid.length][grid[0].length];
        visited[row][0] = 1;

        Queue<int[]> planned = new LinkedList<>();
        planned.offer(new int[]{row, 0});

        int path = -1;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            path++;

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();
                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && grid[current[0]][current[1]] < grid[x][y] && visited[x][y] == 0) {
                        planned.offer(new int[]{x, y});
                        visited[x][y] = 1;
                    }
                }
            }
        }

        return path;
    }
}
