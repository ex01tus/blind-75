package greedy;

/**
 * Description: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class CheckIfParenthesesStringCanBeValid {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int minOpenedNumber = 0;
        int maxOpenedNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            boolean isLocked = locked.charAt(i) == '1';

            if (isLocked) {
                if (current == '(') {
                    minOpenedNumber++;
                    maxOpenedNumber++;
                } else {
                    minOpenedNumber--;
                    maxOpenedNumber--;
                    if (maxOpenedNumber < 0) return false; // too many closed ones
                }
            } else { // count as either '(' or ')'
                minOpenedNumber--;
                maxOpenedNumber++;
            }

            minOpenedNumber = Math.max(0, minOpenedNumber);
        }

        return minOpenedNumber == 0;
    }
}
