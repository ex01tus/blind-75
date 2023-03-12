package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/valid-sudoku
 * Difficulty: Medium
 */
public class ValidSudoku {

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(1)
     */
    public boolean isValidSudokuWithNoExtraSpace(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                board[i][j] = '@'; // temporary remove current num, so it won't mess with validation checks
                if (!isValid(board, i, j, num)) return false;
                board[i][j] = num;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int boxStartRow = 3 * (row / 3);
        int boxStartCol = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num
                    || board[i][col] == num
                    || board[boxStartRow + i / 3][boxStartCol + i % 3] == num) {
                return false;
            }
        }

        return true;
    }

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(n * m)
     */
    public boolean isValidSudokuViaSet(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                if (!seen.add(num + " in row " + i)
                        || !seen.add(num + " in col " + j)
                        || !seen.add(num + " in square " + i / 3 + ":" + j / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
