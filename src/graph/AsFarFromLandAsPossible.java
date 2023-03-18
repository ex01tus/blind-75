package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/as-far-from-land-as-possible
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class AsFarFromLandAsPossible {

    public int maxDistance(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> planned = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    planned.offer(new int[]{i, j});
                }
            }
        }

        // no land cells or no water cells
        if (planned.isEmpty() || planned.size() == grid.length * grid[0].length) {
            return -1;
        }

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
                            && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        planned.offer(new int[]{x, y});
                    }
                }
            }
        }

        return distance - 1;
    }
}
