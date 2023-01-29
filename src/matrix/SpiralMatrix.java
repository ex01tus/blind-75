package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/spiral-matrix
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
public class SpiralMatrix {

    private static final int RIGHT = 0;
    private static final int BOTTOM = 1;
    private static final int LEFT = 2;
    private static final int TOP = 3;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix[0].length - 1;
        int colStart = 0;
        int colEnd = matrix.length - 1;

        int direction = RIGHT;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            switch (direction) {
                case RIGHT:
                    for (int i = rowStart; i <= rowEnd; i++) {
                        result.add(matrix[colStart][i]);
                    }
                    colStart++;
                    break;
                case BOTTOM:
                    for (int i = colStart; i <= colEnd; i++) {
                        result.add(matrix[i][rowEnd]);
                    }
                    rowEnd--;
                    break;
                case LEFT:
                    for (int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[colEnd][i]);
                    }
                    colEnd--;
                    break;
                case TOP:
                    for (int i = colEnd; i >= colStart; i--) {
                        result.add(matrix[i][rowStart]);
                    }
                    rowStart++;
                    break;
            }

            direction = (direction + 1) % 4;
        }

        return result;
    }
}
