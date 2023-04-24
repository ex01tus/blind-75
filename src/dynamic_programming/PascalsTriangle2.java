package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/pascals-triangle-ii
 * Difficulty: Easy
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = List.of(1);
        for (int row = 1; row <= rowIndex; row++) {
            List<Integer> current = new ArrayList<>();
            for (int pos = 0; pos <= prev.size(); pos++) {
                int left = pos > 0 ? prev.get(pos - 1) : 0;
                int right = pos < prev.size() ? prev.get(pos) : 0;

                current.add(left + right);
            }

            prev = current;
        }

        return prev;
    }
}
