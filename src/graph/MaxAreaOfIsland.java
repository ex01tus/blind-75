package graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/max-area-of-island
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaxAreaOfIsland {

    private int[][] directions;
    private int[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited = new int[grid.length][grid[0].length];

        int maxSpace = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int space = dfs(grid, new int[] {i, j});
                    maxSpace = Math.max(space, maxSpace);
                }
            }
        }

        return maxSpace;
    }

    private int dfs(int[][] grid, int[] start) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(start);

        int count = 0;
        while (!stack.isEmpty()) {
            int[] current = stack.poll();

            if (visited[current[0]][current[1]] == 0) {
                visited[current[0]][current[1]] = 1;
                stack.push(current);

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && grid[x][y] == 1
                            && visited[x][y] == 0) {
                        stack.push(new int[] {x, y});
                    }
                }
            } else if (visited[current[0]][current[1]] == 1) {
                count++;
                visited[current[0]][current[1]] = 2;
            }
        }

        return count;
    }
}
