package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/minimum-knight-moves
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumKnightMoves {

    private static final int ZERO = 302;
    private static final int MOVE_RANGE = 607;

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;

        int[][] directions = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        int[][] visited = new int[MOVE_RANGE][MOVE_RANGE];

        Queue<int[]> planned = new LinkedList<>();
        planned.offer(new int[]{0, 0});
        visited[ZERO][ZERO] = 1;

        int moves = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            moves++;

            for (int i = 0; i < levelSize; i++) {
                int[] current = planned.poll();
                for (int[] dir : directions) {
                    int x1 = current[0] + dir[0];
                    int y1 = current[1] + dir[1];

                    if (x1 == x && y1 == y) return moves;
                    if (visited[x1 + ZERO][y1 + ZERO] == 0) {
                        visited[x1 + ZERO][y1 + ZERO] = 1;
                        planned.offer(new int[]{x1, y1});
                    }
                }
            }
        }

        return -1;
    }
}
