package matrix;

/**
 * Description: https://leetcode.com/problems/matrix-diagonal-sum
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MatrixDiagonalSum {

    public int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            sum += matrix[i][n - 1 - i];
        }

        // if matrix dimension is odd
        // -> diagonals intersect on the middle element
        // -> it was added twice
        if (n % 2 != 0) sum -= matrix[n / 2][n / 2];

        return sum;
    }
}
