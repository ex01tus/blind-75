package matrix;

import java.util.List;

/**
 * Description: https://leetcode.com/problems/leftmost-column-with-at-least-a-one
 * Difficulty: Medium
 */
public class LeftmostColumnWithAtLeastOne {

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(1)
     */
    public int leftMostColumnWithOneViaTwoPointers(BinaryMatrix matrix) {
        List<Integer> dimensions = matrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(0);

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix.get(row, col) == 0) {
                row++;
            } else {
                col--;
            }
        }

        return col == cols - 1 ? -1 : col + 1;
    }

    /**
     * Time complexity: O(nlog m)
     * Space complexity: O(1)
     */
    public int leftMostColumnWithOneViaBinarySearch(BinaryMatrix matrix) {
        List<Integer> dimensions = matrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(0);

        int leftmostCol = Integer.MAX_VALUE;
        for (int r = 0; r < rows; r++) {
            int firstOccurrence = findFirstOccurrence(matrix, cols, r);
            leftmostCol = Math.min(leftmostCol, firstOccurrence);
        }

        return leftmostCol == Integer.MAX_VALUE ? -1 : leftmostCol;
    }

    private int findFirstOccurrence(BinaryMatrix matrix, int cols, int row) {
        int left = 0;
        int right = cols - 1;
        int firstOccurrence = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix.get(row, mid);
            if (midElement == 0) {
                left = mid + 1;
            } else { // midElement == 1
                firstOccurrence = mid;
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    interface BinaryMatrix {

        int get(int row, int col);

        List<Integer> dimensions();
    }
}
