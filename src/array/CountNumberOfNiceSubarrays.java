package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/count-number-of-nice-subarrays
 * Difficulty: Medium
 */
public class CountNumberOfNiceSubarrays {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int numberOfSubarraysViaPrefixSum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int count = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += (num % 2 == 0) ? 0 : 1;

            int currentSubarray = currentSum == k ? 1 : 0;
            int prevSubarray = prefixSum.getOrDefault(currentSum - k, 0);

            count += currentSubarray + prevSubarray;
            prefixSum.merge(currentSum, 1, Integer::sum);
        }

        return count;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int numberOfSubarraysViaTwoPointers(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int subarraysSoFar = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                k--;
                subarraysSoFar = 0; // new odd found -> reset the counter
            }

            while (k == 0) {
                k += nums[left] == 1 ? 1 : 0;
                subarraysSoFar++;
                left++;
            }

            count += subarraysSoFar;
        }

        return count;
    }
}
