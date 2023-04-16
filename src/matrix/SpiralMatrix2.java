package matrix;

/**
 * Description: https://leetcode.com/problems/spiral-matrix-ii
 * Difficulty: Medium
 * Time complexity: O(n * n)
 * Space complexity: O(n * n)
 */
public class SpiralMatrix2 {

    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        int direction = RIGHT;
        int val = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            switch (direction) {
                case RIGHT:
                    for (int i = rowStart; i <= rowEnd; i++) {
                        matrix[colStart][i] = val++;
                    }
                    colStart++;
                    break;
                case DOWN:
                    for (int i = colStart; i <= colEnd; i++) {
                        matrix[i][rowEnd] = val++;
                    }
                    rowEnd--;
                    break;
                case LEFT:
                    for (int i = rowEnd; i >= rowStart; i--) {
                        matrix[colEnd][i] = val++;
                    }
                    colEnd--;
                    break;
                case UP:
                    for (int i = colEnd; i >= colStart; i--) {
                        matrix[i][rowStart] = val++;
                    }
                    rowStart++;
                    break;
            }

            direction = (direction + 1) % 4;
        }

        return matrix;
    }
}
