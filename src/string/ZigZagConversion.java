package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/zigzag-conversion
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        boolean goDown = true;
        int currentRow = 0;
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);

            if (goDown) {
                if (currentRow < numRows - 1) {
                    currentRow++;
                } else {
                    goDown = false;
                    currentRow--;
                }
            } else {
                if (currentRow > 0) {
                    currentRow--;
                } else {
                    goDown = true;
                    currentRow++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
