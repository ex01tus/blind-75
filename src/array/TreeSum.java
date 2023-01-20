package array;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/3sum
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class TreeSum {

    public List<List<Integer>> threeSumViaTwoPointers(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSumWithMemoization(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = - nums[i] - nums[j];

                if (seen.contains(target)) {
                    result.add(List.of(nums[i], nums[j], target));
                } else {
                    seen.add(nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }

}
