package matrix;

/**
 * Description: https://leetcode.com/problems/transpose-matrix
 * Difficulty: Easy
 */
public class TransposeMatrix {

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     */
    public int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(1)
     */
    public int[][] transposeSquareMatrixInPlace(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        return matrix;
    }
}
