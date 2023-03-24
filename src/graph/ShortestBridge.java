package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-bridge
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class ShortestBridge {

    private final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> planned = new LinkedList<>();

        boolean isFound = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isFound) break;
                if (grid[i][j] == 1) {
                    findIsland(grid, visited, planned, i, j); // find first island
                    isFound = true;
                }
            }
        }

        // expand first island toward the second one
        return expandAndCount(grid, visited, planned);
    }

    private void findIsland(int[][] grid, int[][] visited, Queue<int[]> planned, int x, int y) {
        visited[x][y] = 1;
        planned.offer(new int[] {x, y});

        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length
                    && grid[x1][y1] == 1 && visited[x1][y1] == 0) {
                findIsland(grid, visited, planned, x1, y1);
            }
        }
    }

    private int expandAndCount(int[][] grid, int[][] visited, Queue<int[]> planned) {
        int bridge = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                            && visited[x][y] == 0) {
                        if (grid[x][y] == 1) return bridge; // second island was found

                        planned.offer(new int[] {x, y});
                        visited[x][y] = 1;
                    }
                }
            }

            bridge++;
        }

        return -1;
    }
}
