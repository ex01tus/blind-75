package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/permutations
 * Difficulty: Medium
 * Time complexity: O(n * n!)
 * Space complexity: O(n)
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(permutation);
            return;
        }

        for (int num : nums) {
            if (permutation.contains(num)) continue;

            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(num);

            backtrack(nums, newPermutation, result);
        }
    }
}
