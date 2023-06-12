package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/snakes-and-ladders
 * Difficulty: Medium
 * Time complexity: O(n * n)
 * Space complexity: O(n * n)
 */
public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int[] labels = initLabels(board);
        return findShortestPath(board, labels);
    }

    private int findShortestPath(int[][] board, int[] labels) {
        Queue<Integer> planned = new LinkedList<>();
        planned.offer(1);
        int[] visited = new int[board.length * board.length + 1];
        visited[1] = 1;

        int path = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            path++;

            for (int i = 0; i < levelSize; i++) {
                int current = planned.poll();
                for (int next = current + 1; next <= Math.min(current + 6, board.length * board.length); next++) {
                    int destination = labels[next] > 0 ? labels[next] : next; // check for possible snake or ladder
                    if (destination == board.length * board.length) return path;

                    if (visited[destination] == 0) {
                        planned.offer(destination);
                        visited[destination] = 1;
                    }
                }
            }
        }

        return -1;
    }

    private int[] initLabels(int[][] board) {
        int[] labels = new int[board.length * board.length + 1];
        boolean goRight = true;
        int val = 1;
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 0; col < board[0].length; col++) {
                labels[val++] = goRight ? board[row][col] : board[row][board[0].length - col - 1];
            }

            goRight = !goRight;
        }

        return labels;
    }
}
