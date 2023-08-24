package matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-smallest-common-element-in-all-rows
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
public class FindSmallestCommonElementInAllRows {

    public int smallestCommonElement(int[][] matrix) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int count = freqMap.merge(matrix[i][j], 1, Integer::sum);
                if (count == matrix.length) return matrix[i][j];
            }
        }

        return -1;
    }
}
