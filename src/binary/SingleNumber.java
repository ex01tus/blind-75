package binary;

/**
 * Description: https://leetcode.com/problems/single-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num; // XOR: 2 ^ 2 ^ 4 ^ 4 ^ 5 = 0 ^ 0 ^ 5 = 5
        }

        return single;
    }
}
