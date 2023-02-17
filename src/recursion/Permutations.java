package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/permutations
 * Difficulty: Medium
 * Time complexity: O(n!)
 * Space complexity: O(n!)
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new int[nums.length], new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int[] used,
            List<Integer> currentPermutation,
            List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;

            currentPermutation.add(nums[i]);
            used[i] = 1;
            backtrack(nums, used, currentPermutation, result);
            used[i] = 0;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
