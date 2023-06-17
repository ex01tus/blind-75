package binary;

/**
 * Description: https://leetcode.com/problems/single-number-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int shift = 0; shift < 32; shift++) {
            int bit = 0;
            for (int num : nums) {
                bit += (num >> shift) & 1;
            }

            bit %= 3;
            single = single | (bit << shift);
        }

        return single;
    }
}
