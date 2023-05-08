package array;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/4sum
 * Difficulty: Medium
 * Time complexity: O(n^3)
 * Space complexity: O(n)
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                long localTarget = (long) target - nums[i] - nums[j];

                while (left < right) {
                    long sum = nums[left] + nums[right];
                    if (sum == localTarget) {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum > localTarget) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
