package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = i + 1;
            } else if (prefixSum.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSum.get(sum - k));
            }

            prefixSum.putIfAbsent(sum, i);
        }

        return maxLength;
    }
}
