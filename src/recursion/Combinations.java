package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/combinations
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(k)
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = initArray(n);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), k, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int start,
            List<Integer> currentCombination,
            int k,
            List<List<Integer>> result) {
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currentCombination.add(nums[i]);
            backtrack(nums, i + 1, currentCombination, k, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    private int[] initArray(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        return nums;
    }
}
