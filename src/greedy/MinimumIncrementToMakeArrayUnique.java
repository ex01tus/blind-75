package greedy;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-increment-to-make-array-unique
 * Difficulty: Medium
 */
public class MinimumIncrementToMakeArrayUnique {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int minIncrementForUniqueViaCounting(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // `x` will never be larger than `nums.length + max`
        int[] freqMap = new int[nums.length + max];
        for (int num : nums) {
            freqMap[num]++;
        }

        int increments = 0;
        for (int x = 0; x < freqMap.length; x++) {
            if (freqMap[x] < 2) continue;

            // keep one value and increment all the rest
            int remains = freqMap[x] - 1;
            increments += remains;
            freqMap[x + 1] += remains;
        }

        return increments;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int minIncrementForUniqueViaSorting(int[] nums) {
        Arrays.sort(nums);

        int increments = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                increments += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return increments;
    }
}
