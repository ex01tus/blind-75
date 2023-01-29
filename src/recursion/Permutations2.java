package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/permutations-ii
 * Difficulty: Medium
 * Time complexity: O(n!)
 * Space complexity: O(n!)
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new int[nums.length], new ArrayList<>(), permutations);

        return permutations;
    }

    private void backtrack(
            int[] nums,
            int[] used,
            List<Integer> permutation,
            List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;

            permutation.add(nums[i]);
            used[i] = 1;
            backtrack(nums, used, permutation, result);
            used[i] = 0;
            permutation.remove(permutation.size() - 1);
        }
    }
}
