package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/combination-sum-iii
 * Difficulty: Medium
 * Time complexity: O(2^9) -> O(1)
 * Space complexity: O(k)
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = initArray(n);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), n, k, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int start,
            List<Integer> currentCombination,
            int remains,
            int k,
            List<List<Integer>> result) {
        if (remains < 0) return;

        if (currentCombination.size() == k) {
            if (remains == 0) result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currentCombination.add(nums[i]);
            backtrack(nums, i + 1, currentCombination, remains - nums[i], k, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    private int[] initArray(int n) {
        int size = Math.min(n, 9);
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i + 1;
        }

        return nums;
    }
}
