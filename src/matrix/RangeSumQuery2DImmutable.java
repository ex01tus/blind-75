package matrix;

/**
 * Description: https://leetcode.com/problems/range-sum-query-2d-immutable
 * Difficulty: Medium
 * Time complexity: O(n) for constructor() and O(1) for sumRegion()
 * Space complexity: O(n)
 */
public class RangeSumQuery2DImmutable {

    private static class NumMatrix {

        // stores the sum of all elements in rectangle [0,0] – [i][j]
        private final int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            this.prefixSum = populatePrefixSumMatrix(matrix);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2 + 1][col2 + 1]
                    - prefixSum[row2 + 1][col1]
                    - prefixSum[row1][col2 + 1]
                    + prefixSum[row1][col1];
        }

        private int[][] populatePrefixSumMatrix(int[][] matrix) {
            int[][] prefixSum = new int[matrix.length + 1][matrix[0].length + 1];

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    prefixSum[row + 1][col + 1] = prefixSum[row][col + 1]
                            + prefixSum[row + 1][col]
                            + matrix[row][col]
                            - prefixSum[row][col];
                }
            }

            return prefixSum;
        }
    }
}
