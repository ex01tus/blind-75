package matrix;

import java.util.List;

/**
 * Description: https://leetcode.com/problems/valid-word-square
 * Difficulty: Easy
 * Time complexity: O(m * n)
 * Space complexity: O(1)
 */
public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        for (int row = 0; row < words.size(); row++) {
            for (int col = 0; col < words.get(row).length(); col++) {
                if (col >= words.size()
                        || row >= words.get(col).length()
                        || words.get(row).charAt(col) != words.get(col).charAt(row)) {
                    return false;
                }
            }
        }

        return true;
    }
}
