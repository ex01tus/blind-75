package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/the-maze-ii
 * Difficulty: Medium
 * Time complexity: O(edges * log n)
 * Space complexity: O(n)
 */
public class Maze2 {

    public int shortestDistanceViaDijkstraAlgo(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<Tuple> planned = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        planned.offer(new Tuple(start[0], start[1], 0));

        int[][] distances = new int[maze.length][maze[0].length];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        while (!planned.isEmpty()) {
            Tuple current = planned.poll();
            if (current.distance > distances[current.x][current.y]) continue;

            if (current.x == destination[0] && current.y == destination[1]) {
                return current.distance;
            }

            distances[current.x][current.y] = current.distance;

            for (int[] dir : directions) {
                int x = current.x;
                int y = current.y;

                int distance = 0;
                while (!isWall(x, y, maze)) {
                    x += dir[0];
                    y += dir[1];
                    distance += 1;
                }

                x -= dir[0];
                y -= dir[1];
                distance -= 1;

                if (distances[x][y] == Integer.MAX_VALUE) {
                    planned.offer(new Tuple(x, y, current.distance + distance));
                }
            }
        }

        return -1;
    }

    private boolean isWall(int x, int y, int[][] maze) {
        return x < 0 || y < 0 || x >= maze.length || y >= maze[0].length
                || maze[x][y] == 1;
    }

    private record Tuple(int x, int y, int distance) {
    }
}
