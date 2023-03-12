package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/n-queens-ii
 * Difficulty: Hard
 * Time complexity: O(n!)
 * Space complexity: O(n)
 */
public class NQueens2 {

    public int totalNQueens(int n) {
        return solve(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int solve(
            int n,
            int row,
            Set<Integer> attackedColumns,
            Set<Integer> attackedNegativeDiagonals,   // negative diagonal has constant (col - row) value
            Set<Integer> attackedPositiveDiagonals) { // positive diagonal has constant (col + row) value
        if (row == n) return 1;

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (attackedColumns.contains(col)
                    || attackedPositiveDiagonals.contains(col + row)
                    || attackedNegativeDiagonals.contains(col - row)) {
                continue;
            }

            attackedColumns.add(col);
            attackedPositiveDiagonals.add(col + row);
            attackedNegativeDiagonals.add(col - row);

            count += solve(n, row + 1,
                    attackedColumns, attackedNegativeDiagonals, attackedPositiveDiagonals);

            attackedColumns.remove(col);
            attackedPositiveDiagonals.remove(col + row);
            attackedNegativeDiagonals.remove(col - row);
        }


        return count;
    }
}
