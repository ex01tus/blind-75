package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/subarray-sum-equals-k
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int targetSum) {
        Map<Long, Integer> prefixSumFrequencyMap = new HashMap<>();

        int count = 0;
        long currentSum = 0;
        for (int num : nums) {
            currentSum += num;

            int currentSubarray = currentSum == targetSum ? 1 : 0;
            int previousSubarrays = prefixSumFrequencyMap.getOrDefault(currentSum - targetSum, 0);

            count += currentSubarray + previousSubarrays;

            prefixSumFrequencyMap.merge(currentSum, 1, Integer::sum);
        }

        return count;
    }
}
