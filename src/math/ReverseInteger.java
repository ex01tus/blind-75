package math;

/**
 * Description: https://leetcode.com/problems/reverse-integer
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReverseInteger {

    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int signedDigit = x % 10;
            x = x / 10;

            if (reversed > Integer.MAX_VALUE / 10
                    // reversed = 214748364; signedDigit = 8 -> reversed * 10 + signedDigit > MAX_VALUE
                    || (reversed == Integer.MAX_VALUE / 10 && signedDigit > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10
                    // reversed = -214748364; signedDigit = -9 -> reversed * 10 + signedDigit < MIN_VALUE
                    || (reversed == Integer.MIN_VALUE / 10 && signedDigit < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            reversed = reversed * 10 + signedDigit;
        }

        return reversed;
    }
}
