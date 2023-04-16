package string;

/**
 * Description: https://leetcode.com/problems/moving-average-from-data-stream
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RemovingStarsFromString {

    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                result.append(c);
            } else {
                result.deleteCharAt(result.length() - 1);
            }
        }

        return result.toString();
    }
}
