package string;

/**
 * Description: https://leetcode.com/problems/string-to-integer-atoi
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0; // empty

        int pointer = trim(s);
        if (pointer == s.length()) return 0; // empty after trim

        int sign = 1;
        if (s.charAt(pointer) == '-') {
            sign = -1;
            pointer++;
        } else if (s.charAt(pointer) == '+') {
            pointer++;
        }

        return computeResult(s, pointer, sign);
    }

    private int computeResult(String s, int pointer, int sign) {
        long result = 0L;
        while (pointer < s.length()) {
            char currentChar = s.charAt(pointer);
            if (!Character.isDigit(currentChar)) break;

            result = result * 10 + Character.getNumericValue(currentChar);

            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            pointer++;
        }

        return (int) result * sign;
    }

    private int trim(String s) {
        int pointer = 0;
        while (pointer < s.length() && s.charAt(pointer) == ' ') {
            pointer++;
        }

        return pointer;
    }
}
