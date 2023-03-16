package greedy;

/**
 * Description: https://leetcode.com/problems/valid-parenthesis-string
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ValidParenthesesString {

    public boolean checkValidString(String s) {
        int minOpenedNumber = 0;
        int maxOpenedNumber = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpenedNumber++;
                maxOpenedNumber++;
            } else if (c == ')') {
                minOpenedNumber--;
                maxOpenedNumber--;
                if (maxOpenedNumber < 0) return false; // too many closed ones
            } else { // '*' can be used as either ')' or '('
                minOpenedNumber--;
                maxOpenedNumber++;
            }

            minOpenedNumber = Math.max(0, minOpenedNumber);
        }

        return minOpenedNumber == 0;
    }
}
