package graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/rotting-oranges
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class NumberOfIslands {

    int[][] visited;
    int[][] directions;
    int initialColor = 2;
    int currentColor = initialColor;

    public int numIslands(char[][] grid) {
        visited = new int[grid.length][grid[0].length];
        directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    dfs(new int[] {i, j}, grid);
                    currentColor++;
                }
            }
        }

        return currentColor - initialColor;
    }

    private void dfs(int[] start, char[][] grid) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            if (visited[current[0]][current[1]] == 0) {
                visited[current[0]][current[1]] = 1;
                stack.push(current);

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && visited[x][y] == 0
                            && grid[x][y] == '1') {
                        stack.push(new int[] {x, y});
                    }
                }
            } else if (visited[current[0]][current[1]] == 1) {
                visited[current[0]][current[1]] = currentColor;
            }
        }
    }
}
