package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/count-submatrices-with-all-ones
 * Difficulty: Medium
 * Time complexity: O(m * n * n)
 * Space complexity: O(n)
 */
public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int count = 0;

        int[] heights = new int[mat[0].length];
        for (int row = 0; row < mat.length; row++) {
            // represent each row as a histogram
            for (int col = 0; col < mat[0].length; col++) {
                // with each column being a bar of certain height
                heights[col] = mat[row][col] == 0 ? 0 : heights[col] + 1;
                int minHeight = heights[col];
                for (int bar = col; bar >= 0; bar--) {
                    minHeight = Math.min(minHeight, heights[bar]);
                    count += minHeight;
                }
            }
        }

        return count;
    }
}
