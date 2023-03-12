package recursion;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/n-queens
 * Difficulty: Hard
 * Time complexity: O(n!)
 * Space complexity: O(n)
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        solve(new ArrayList<>(), n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), solution);

        return solution;
    }

    private void solve(
            List<String> currentBoard,
            int n,
            int row,
            Set<Integer> attackedColumns,
            Set<Integer> attackedNegativeDiagonals, // negative diagonal has constant (col - row) value
            Set<Integer> attackedPositiveDiagonals, // positive diagonal has constant (col + row) value
            List<List<String>> solution) {
        if (currentBoard.size() == n) {
            solution.add(new ArrayList<>(currentBoard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (attackedColumns.contains(col)
                    || attackedPositiveDiagonals.contains(col + row)
                    || attackedNegativeDiagonals.contains(col - row)) {
                continue;
            }

            currentBoard.add(lineWithQueen(col, n));
            attackedColumns.add(col);
            attackedPositiveDiagonals.add(col + row);
            attackedNegativeDiagonals.add(col - row);

            solve(currentBoard, n, row + 1,
                    attackedColumns, attackedNegativeDiagonals, attackedPositiveDiagonals,
                    solution);

            currentBoard.remove(currentBoard.size() - 1);
            attackedColumns.remove(col);
            attackedPositiveDiagonals.remove(col + row);
            attackedNegativeDiagonals.remove(col - row);
        }
    }

    private String lineWithQueen(int position, int n) {
        char[] line = new char[n];
        Arrays.fill(line, '.');
        line[position] = 'Q';

        return new String(line);
    }
}
