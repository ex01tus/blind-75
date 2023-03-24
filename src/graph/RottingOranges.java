package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/rotting-oranges
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> planned = new LinkedList<>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[grid.length][grid[0].length];
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    planned.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        if (fresh == 0) return 0; // no fresh oranges -> no rotting "needed"

        int time = 0;
        while (!planned.isEmpty() && fresh > 0) {
            int levelSize = planned.size();
            time++;

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && visited[x][y] == 0
                            && grid[x][y] == 1) {
                        visited[x][y] = 1;
                        planned.offer(new int[]{x, y});

                        if (--fresh == 0) return time;
                    }
                }
            }
        }

        return -1;
    }
}
