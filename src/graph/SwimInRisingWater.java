package graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/swim-in-rising-water
 * Difficulty: Hard
 * Time complexity: O(m * n * log mn)
 * Space complexity: O(m * n)
 */
public class SwimInRisingWater {

    private final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWaterViaModifiedDijkstraAlgo(int[][] grid) {
        Queue<Point> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a.x][a.y]));
        minHeap.offer(new Point(0, 0));
        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 1;

        int max = 0;
        while (!minHeap.isEmpty()) {
            Point current = minHeap.poll();
            max = Math.max(max, grid[current.x][current.y]);
            if (current.x == grid.length - 1 && current.y == grid[0].length - 1) return max;

            for (int[] dir : directions) {
                int x = current.x + dir[0];
                int y = current.y + dir[1];

                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                        && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    minHeap.offer(new Point(x, y));
                }
            }
        }

        return max;
    }

    private record Point(int x, int y) {}
}
