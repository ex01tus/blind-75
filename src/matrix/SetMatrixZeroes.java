package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/set-matrix-zeroes
 * Difficulty: Medium
 */
public class SetMatrixZeroes {

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(1)
     */
    public void setZeroesWithConstantSpace(int[][] matrix) {
        // Use separate flags for the first col and row
        boolean isFirstColZeroed = isFirstColZeroed(matrix);
        boolean isFirstRowZeroed = isFirstRowZeroed(matrix);

        // Use the first col and row cells as flags
        markZeroedRowsAndCols(matrix);

        // Set zeroes, but not in the first row and col
        setZeroesInInnerMatrix(matrix);

        if (isFirstColZeroed) setZeroesInFirstCol(matrix);
        if (isFirstRowZeroed) setZeroesInFirstRow(matrix);
    }

    private static boolean isFirstColZeroed(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean isFirstRowZeroed(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                return true;
            }
        }

        return false;
    }

    private static void markZeroedRowsAndCols(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    }

    private static void setZeroesInInnerMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void setZeroesInFirstCol(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }


    private static void setZeroesInFirstRow(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(m + n)
     */
    public void setZeroesViaTwoSets(int[][] matrix) {
        Set<Integer> zeroedCols = new HashSet<>();
        Set<Integer> zeroedRows = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroedCols.add(i);
                    zeroedRows.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroedCols.contains(i) || zeroedRows.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
