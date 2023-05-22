package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-to-get-food
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ShortestPathToGetFood {

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int getFood(char[][] grid) {
        int[] start = findStart(grid);
        return findShortestPath(grid, start);
    }

    private int findShortestPath(char[][] grid, int[] start) {
        int[][] visited = new int[grid.length][grid[0].length];

        Queue<int[]> planned = new LinkedList<>();
        planned.offer(start);
        visited[start[0]][start[1]] = 1;

        int distance = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();
                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                            && grid[x][y] != 'X'
                            && visited[x][y] == 0) {
                        if (grid[x][y] == '#') return distance;
                        planned.offer(new int[]{x, y});
                        visited[x][y] = 1;
                    }
                }
            }
        }

        return -1;
    }

    private int[] findStart(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') return new int[]{i, j};
            }
        }

        return null;
    }
}
