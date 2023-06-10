package matrix;

/**
 * Description: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(1)
 */
public class CountNegativeNumbersInSortedMatrix {

    public int countNegatives(int[][] grid) {
        int count = 0;
        int row = 0;
        int col = grid[0].length - 1;

        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                count += grid.length - row;
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}
