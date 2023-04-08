package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/minimum-falling-path-sum
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int[] prevRow = matrix[0];
        for (int row = 1; row < matrix.length; row++) {
            int[] currRow = new int[matrix.length];
            for (int col = 0; col < matrix[0].length; col++) {
                int pathFromCenter = prevRow[col];
                int pathFromLeft = col > 0 ? prevRow[col - 1] : Integer.MAX_VALUE;
                int pathFromRight = col < matrix[0].length - 1 ? prevRow[col + 1] : Integer.MAX_VALUE;

                int smallestAbove = Math.min(pathFromCenter, Math.min(pathFromLeft, pathFromRight));
                currRow[col] = smallestAbove + matrix[row][col];
            }

            prevRow = currRow;
        }

        int min = Integer.MAX_VALUE;
        for (int value : prevRow) {
            min = Math.min(min, value);
        }

        return min;
    }
}
