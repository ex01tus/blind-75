package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class NearestExitFromEntranceInMaze {

    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] visited = new int[maze.length][maze[0].length];

        Queue<int[]> planned = new LinkedList<>();
        planned.offer(entrance);
        visited[entrance[0]][entrance[1]] = 1;

        int distance = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
                        if (current[0] == entrance[0] && current[1] == entrance[1]) continue;
                        return distance;
                    }

                    if (maze[x][y] == '.' && visited[x][y] == 0) {
                        planned.offer(new int[]{x, y});
                        visited[x][y] = 1;
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}
