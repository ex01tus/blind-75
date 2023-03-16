package math;

/**
 * Description: https://leetcode.com/problems/power-of-three
 * Difficulty: Easy
 */
public class PowerOfThree {

    /**
     * Time complexity: O(log3 n)
     * Space complexity: O(1)
     */
    public boolean isPowerOfThreeViaLoop(int n) {
        if (n < 1) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    /**
     * Time complexity: O(log3 n)
     * Space complexity: O(log3 n)
     */
    public boolean isPowerOfThreeViaRecursion(int n) {
        if (n < 1) return false;
        if (n == 1) return true;

        return n % 3 == 0 && isPowerOfThreeViaRecursion(n / 3);
    }

    /**
     * Time complexity: O(log3 n)
     * Space complexity: O(log3 n)
     */
    public boolean isPowerOfThreeViaBaseConversion(int n) {
        return Integer.toString(n, 3)
                .matches("^10*$"); // in base 3 all powers of 3 start with 1
    }
}
