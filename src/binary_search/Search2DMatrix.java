package binary_search;

/**
 * Description: https://leetcode.com/problems/search-a-2d-matrix
 * Difficulty: Medium
 */
public class Search2DMatrix {

    /**
     * Time complexity: O(log n + log m)
     * Space complexity: O(1)
     */
    public boolean searchMatrixViaBinarySearch(int[][] matrix, int target) {
        int row = findRowNumber(matrix, target);
        return containsTarget(matrix[row], target);
    }

    private int findRowNumber(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target > matrix[mid][matrix[0].length - 1]){
                left = mid + 1;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    private boolean containsTarget(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target > row[mid]) {
                left = mid + 1;
            } else if (target < row[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(1)
     */
    public boolean searchMatrixFromTopRightCorner(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }
}
