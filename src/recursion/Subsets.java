package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/subsets
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(subset);

        if (subset.size() == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[i]);
            backtrack(nums, i + 1, newSubset, result);
        }
    }
}
