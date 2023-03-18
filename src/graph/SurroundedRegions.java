package graph;

/**
 * Description: https://leetcode.com/problems/surrounded-regions
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class SurroundedRegions {

    private final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'F') { // all 'F' regions have access to the boarders
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') { // the rest of 'O' are surrounded
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O') return;

        board[x][y] = 'F';
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length) {
                dfs(board, x1, y1);
            }
        }
    }
}
