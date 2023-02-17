package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/contiguous-array
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) { // [0; i] has equal number of `0` and `1`
                maxLength = i + 1;
            } else if (prefixSum.containsKey(sum)) { // [prefix + 1; i] has equal number of `0` and `1`
                maxLength = Math.max(maxLength, i - prefixSum.get(sum));
            } else {
                prefixSum.put(sum, i);
            }
        }

        return maxLength;
    }
}
