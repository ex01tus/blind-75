package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/valid-sudoku
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cell = board[i][j];
                if (cell == '.') continue;

                if (!seen.add(cell + " in row " + i)
                        || !seen.add(cell + " in col " + j)
                        || !seen.add(cell + " in square " + i/3 + ":" + j/3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
