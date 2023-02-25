package matrix;

/**
 * Description: https://leetcode.com/problems/search-a-2d-matrix-ii
 * Difficulty: Medium
 * Time complexity: O(m + n)
 * Space complexity: O(1)
 */
public class Search2DMatrix2 {

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
