package binary;

/**
 * Description: https://leetcode.com/problems/single-number-iii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        // result of XOR on `a` and `b`
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }

        // rightmost different bit between `a` and `b`
        int mask = xor & (xor - 1) ^ xor;

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((mask & num) == mask) {
                // all numbers that can possibly be `a`
                a = a ^ num;
            } else {
                // all numbers that can possibly be `b`
                b = b ^ num;
            }
        }

        // after deduplication we found both `a` and `b`
        return new int[] {a, b};
    }
}
