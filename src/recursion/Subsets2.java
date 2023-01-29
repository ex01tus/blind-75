package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/subsets-ii
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0, subsets);

        return subsets;
    }

    private void backtrack(int[] nums, List<Integer> subset, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            backtrack(nums, subset, i + 1, result);
            subset.remove(subset.size() - 1);
        }
    }
}
