package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/pascals-triangle
 * Difficulty: Easy
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = buildRow(i + 1, result.get(i - 1));
            result.add(row);
        }

        return result;
    }

    private List<Integer> buildRow(int size, List<Integer> prevRow) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        int left = 0;
        int right = 1;
        for (int i = 1; i < size - 1; i++) {
            row.add(prevRow.get(left) + prevRow.get(right));
            left++;
            right++;
        }

        row.add(1);

        return row;
    }
}
