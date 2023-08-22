package math;

/**
 * Description: https://leetcode.com/problems/excel-sheet-column-title
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int col) {
        StringBuilder converted = new StringBuilder();
        while (col > 0) {
            col--;
            converted.append((char) (col % 26 + 'A'));
            col = col / 26;
        }

        return converted.reverse().toString();
    }
}
