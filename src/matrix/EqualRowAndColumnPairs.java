package matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/equal-row-and-column-pairs
 * Difficulty: Medium
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
public class EqualRowAndColumnPairs {

    public int equalPairsViaFreqMap(int[][] grid) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (int[] row : grid) {
            freqMap.merge(Arrays.toString(row), 1, Integer::sum);
        }

        int pairs = 0;
        for (int col = 0; col < grid[0].length; col++) {
            int[] column = new int[grid.length];
            for (int row = 0; row < grid[0].length; row++) {
                column[row] = grid[row][col];
            }

            pairs += freqMap.getOrDefault(Arrays.toString(column), 0);
        }

        return pairs;
    }

    public int equalPairsViaTransposition(int[][] grid) {
        int[][] transposed = transpose(grid);
        int pairs = 0;
        for (int[] originalRow : grid) {
            for (int[] transposedRow : transposed) {
                if (Arrays.equals(originalRow, transposedRow)) pairs++;
            }
        }

        return pairs;
    }

    private int[][] transpose(int[][] grid) {
        int[][] transposed = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                transposed[j][i] = grid[i][j];
            }
        }

        return transposed;
    }
}
