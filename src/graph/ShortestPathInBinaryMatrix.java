package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-in-binary-matrix
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class ShortestPathInBinaryMatrix {

    private final int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // diagonal movement is allowed
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        int[][] visited = new int[grid.length][grid[0].length];

        Queue<int[]> planned = new LinkedList<>();
        planned.offer(new int[]{grid.length - 1, grid[0].length - 1});
        visited[grid.length - 1][grid[0].length - 1] = 1;

        int pathLength = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            pathLength++;

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();
                if (current[0] == 0 && current[1] == 0) {
                    return pathLength;
                }

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                            && grid[x][y] == 0
                            && visited[x][y] == 0) {
                        planned.offer(new int[]{x, y});
                        visited[x][y] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
