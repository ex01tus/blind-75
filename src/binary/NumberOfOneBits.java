package binary;

/**
 * Description: https://leetcode.com/problems/number-of-1-bits
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            ones += n & 1; // if last digit is 1 -> +1
            n = n >>> 1;   // unsigned shift
        }

        return ones;
    }
}
