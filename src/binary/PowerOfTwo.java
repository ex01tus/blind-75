package binary;

/**
 * Description: https://leetcode.com/problems/power-of-two
 * Difficulty: Easy
 */
public class PowerOfTwo {

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean isPowerOfTwoViaBitManipulation(int n) {
        // 4 = 100; 4 - 1 = 3 = 11; 100 & 11 = 0
        // 8 = 1000; 8 - 1 = 7 = 111; 1000 & 111 = 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Time complexity: O(log n)
     * Space complexity: O(log n)
     */
    public boolean isPowerOfTwoViaBaseConversion(int n) {
        return Integer.toString(n, 2).matches("^10*$");
    }
}
