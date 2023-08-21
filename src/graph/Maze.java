package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/the-maze
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
public class Maze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<int[]> planned = new LinkedList<>();
        planned.offer(start);

        int[][] visited = new int[maze.length][maze[0].length];
        visited[start[0]][start[1]] = 1;

        while (!planned.isEmpty()) {
            int[] current = planned.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }

            for (int[] dir : directions) {
                int x = current[0];
                int y = current[1];

                while (!isWall(maze, x, y)) {
                    x += dir[0];
                    y += dir[1];
                }

                // go one step back, because we've reached a wall
                x -= dir[0];
                y -= dir[1];

                if (visited[x][y] == 0) {
                    visited[x][y] = 1;
                    planned.offer(new int[]{x, y});
                }
            }
        }

        return false;
    }

    private boolean isWall(int[][] maze, int x, int y) {
        return x < 0 || y < 0 || x >= maze.length || y >= maze[0].length
                || maze[x][y] == 1;
    }
}
