package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/binary-subarrays-with-sum
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int count = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;

            int currentSubarray = currentSum == goal ? 1 : 0;
            int prevSubarrays = prefixSum.getOrDefault(currentSum - goal, 0);

            count += currentSubarray + prevSubarrays;
            prefixSum.merge(currentSum, 1, Integer::sum);
        }

        return count;
    }
}
