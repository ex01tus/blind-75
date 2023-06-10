package matrix;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/delete-greatest-value-in-each-row
 * Difficulty: Easy
 * Time complexity: O(m * nlog n + m * n)
 * Space complexity: O(log n)
 */
public class DeleteGreatestValueInEachRow {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int result = 0;
        for (int col = 0; col < grid[0].length; col++) {
            int max = 0;
            for (int row = 0; row < grid.length; row++) {
                max = Math.max(max, grid[row][col]);
            }

            result += max;
        }

        return result;
    }
}
