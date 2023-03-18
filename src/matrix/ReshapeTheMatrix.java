package matrix;

/**
 * Description: https://leetcode.com/problems/reshape-the-matrix
 * Difficulty: Easy
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                reshaped[row][col] = mat[i][j];
                col++;

                if (col == reshaped[0].length) {
                    row++;
                    col = 0;
                }
            }
        }

        return reshaped;
    }
}
