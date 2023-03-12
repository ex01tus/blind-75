package dynamic_programming;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/partition-equal-subset-sum
 * Difficulty: Medium
 * Time complexity: O(target * n)
 * Space complexity: O(target * n)
 */
public class PartitionEqualSubsetSum {

    public boolean canPartitionViaDP(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        Set<Integer> prevPartitionSums = new HashSet<>();
        prevPartitionSums.add(0);
        for (int num : nums) {
            Set<Integer> sums = new HashSet<>();    // we need an additional temporary set, because we can't modify
            for (int prevSum : prevPartitionSums) { // main set, while iterating through it
                int newSum = prevSum + num;
                if (newSum == target) return true;
                if (newSum > target) continue;

                sums.add(newSum);
            }

            prevPartitionSums.addAll(sums);
        }

        return false;
    }

    public boolean canPartitionViaRecursion(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        Arrays.sort(nums);

        return isExist(nums, target, new ArrayList<>(), 0, new HashSet<>());
    }

    private boolean isExist(
            int[] nums,
            int remains,
            List<Integer> subset,
            int start,
            Set<String> failedChecks) {
        if (remains == 0) return true;
        if (remains < 0) return false;

        String startToRemainsKey = start + ":" + remains;
        if (failedChecks.contains(startToRemainsKey)) return false;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            boolean isExist = isExist(nums, remains - nums[i], subset, i + 1, failedChecks);
            subset.remove(subset.size() - 1);

            if (isExist) return true;
            failedChecks.add(startToRemainsKey);
        }

        failedChecks.add(startToRemainsKey);
        return false;
    }
}
