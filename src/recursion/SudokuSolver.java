package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/sudoku-solver
 * Difficulty: Hard
 * Time complexity: O(9^(n * n))
 * Space complexity: O(9^(n * n))
 */
public class SudokuSolver {

    public void solveSudokuWithNoExtraSpace(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (!isValid(board, row, col, num)) continue;

                    board[row][col] = num;
                    if (solve(board)) return true;
                    board[row][col] = '.';
                }

                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int boxStartRow = 3 * (row / 3);
        int boxStartCol = 3 * (col / 3);

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num
                    || board[i][col] == num
                    || board[boxStartRow + i / 3][boxStartCol + i % 3] == num) return false;
        }

        return true;
    }

    public void solveSudokuViaSet(char[][] board) {
        Set<String> seen = initSeen(board);
        solve(board, seen);
    }

    private boolean solve(char[][] board, Set<String> seen) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') continue;

                for (char num = '1'; num <= '9'; num++) {
                    if (seen.contains("row-" + row + ":" + num)
                            || seen.contains("col-" + col + ":" + num)
                            || seen.contains("box-" + row / 3 + "-" + col / 3 + ":" + num)) {
                        continue;
                    }

                    board[row][col] = num;
                    seen.add("row-" + row + ":" + num);
                    seen.add("col-" + col + ":" + num);
                    seen.add("box-" + row / 3 + "-" + col / 3 + ":" + num);
                    if (solve(board, seen)) return true;
                    board[row][col] = '.';
                    seen.remove("row-" + row + ":" + num);
                    seen.remove("col-" + col + ":" + num);
                    seen.remove("box-" + row / 3 + "-" + col / 3 + ":" + num);
                }

                return false;
            }
        }

        return true;
    }

    private Set<String> initSeen(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char num = board[row][col];
                if (num == '.') continue;

                seen.add("row-" + row + ":" + num);
                seen.add("col-" + col + ":" + num);
                seen.add("box-" + row / 3 + "-" + col / 3 + ":" + num);
            }
        }

        return seen;
    }
}
