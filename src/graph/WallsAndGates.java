package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/walls-and-gates
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] visited = new int[rooms.length][rooms[0].length];
        Queue<int[]> planned = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    planned.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        while (!planned.isEmpty()) {
            int[] current = planned.poll();

            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];

                if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length
                        && rooms[x][y] > 0 && visited[x][y] == 0) {
                    planned.offer(new int[]{x, y});
                    rooms[x][y] = rooms[current[0]][current[1]] + 1;
                    visited[x][y] = 1;
                }
            }
        }
    }
}
