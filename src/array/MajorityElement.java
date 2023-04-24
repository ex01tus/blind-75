package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/majority-element
 * Difficulty: Easy
 */
public class MajorityElement {

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(1)
     */
    public int majorityElementViaSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int majorityElementViaMooreAlgo(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // it is guaranteed that there's a majority element, so no need for second pass
        return candidate;
    }
}
