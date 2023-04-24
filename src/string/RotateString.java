package string;

/**
 * Description: https://leetcode.com/problems/rotate-string
 * Difficulty: Easy
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.equals(goal)) return true;
            s = s.substring(1) + s.charAt(0);
        }

        return false;
    }
}
