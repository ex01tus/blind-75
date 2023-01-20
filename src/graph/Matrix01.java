package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/01-matrix
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class Matrix01 {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> planned = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = 1;
                    planned.offer(new int[]{i, j});
                }
            }
        }

        while (!planned.isEmpty()) {
            int[] current = planned.poll();

            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];

                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length
                        && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    matrix[x][y] = matrix[current[0]][current[1]] + 1;
                    planned.offer(new int[]{x, y});
                }
            }
        }

        return matrix;
    }
}
