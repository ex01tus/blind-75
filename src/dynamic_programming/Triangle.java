package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/triangle
 * Difficulty: Medium
 */
public class Triangle {

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public int minimumTotalWithOptimizedSpace(List<List<Integer>> triangle) {
        List<Integer> prevRow = triangle.get(0);

        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> currRow = new ArrayList<>();
            for (int pos = 0; pos <= row; pos++) {
                int pathFromLeft = pos > 0 ? prevRow.get(pos - 1) : Integer.MAX_VALUE;
                int pathFromRight = pos < row ? prevRow.get(pos) : Integer.MAX_VALUE;
                int current = triangle.get(row).get(pos);

                int minPath = Math.min(pathFromLeft, pathFromRight) + current;
                currRow.add(minPath);
            }

            prevRow = currRow;
        }

        return Collections.min(prevRow);
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>(triangle.size());
        dp.add(triangle.get(0));

        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> currRow = new ArrayList<>();
            dp.add(currRow);
            for (int pos = 0; pos <= row; pos++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (pos > 0) {
                    smallestAbove = dp.get(row - 1).get(pos - 1);
                }

                if (pos < row) {
                    smallestAbove = Math.min(smallestAbove, dp.get(row - 1).get(pos));
                }

                int current = triangle.get(row).get(pos);
                currRow.add(smallestAbove + current);
            }
        }

        return Collections.min(dp.get(triangle.size() - 1));
    }
}
