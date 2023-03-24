package matrix;

/**
 * Description: https://leetcode.com/problems/game-of-life
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(1)
 */
public class GameOfLife {

    private final int[][] directions = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    private static final int LIVE = 1;
    private static final int DEAD = 0;
    private static final int REPRODUCING = -1;
    private static final int DYING = 2;

    public void gameOfLife(int[][] board) {
        markDyingAndReproducingCells(board);
        buildFinalState(board);
    }

    private void markDyingAndReproducingCells(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j, board);

                if (board[i][j] == LIVE && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
                    board[i][j] = DYING;
                } else if (board[i][j] == DEAD && aliveNeighbors == 3) {
                    board[i][j] = REPRODUCING;
                }
            }
        }
    }

    private void buildFinalState(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == DYING) {
                    board[i][j] = DEAD;
                } else if (board[i][j] == REPRODUCING) {
                    board[i][j] = LIVE;
                }
            }
        }
    }

    private int countAliveNeighbors(int x, int y, int[][] board) {
        int alive = 0;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length) {
                if (board[x1][y1] >= 1) { // DYING cells are still alive, REPRODUCING cells are still dead
                    alive++;
                }
            }
        }

        return alive;
    }
}
