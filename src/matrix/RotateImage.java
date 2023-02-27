package matrix;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/rotate-image
 * Difficulty: Medium
 * Time complexity: O(n * n)
 * Space complexity: O(1)
 */
public class RotateImage {

    public void rotateClockwise(int[][] matrix) {
        transpose(matrix);
        flipHorizontally(matrix);
    }

    public void rotateAntiClockwise(int[][] matrix) {
        transpose(matrix);
        flipVertically(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private void flipHorizontally(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = tmp;
            }
        }
    }

    private void flipVertically(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix[0].length - 1 - i][j];
                matrix[matrix[0].length - 1 - i][j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original: " + Arrays.deepToString(matrix));

        new RotateImage().rotateClockwise(matrix);
        System.out.println("Rotated:  " + Arrays.deepToString(matrix));
    }
}
