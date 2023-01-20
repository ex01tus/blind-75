package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/combination-sum
 * Difficulty: Medium
 * Time complexity: O(n * n!)
 * Space complexity: O(n)
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), 0, result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int remains,
            List<Integer> permutation,
            int start,
            List<List<Integer>> result) {
        if (remains == 0) {
            result.add(permutation);
            return;
        }

        if (remains < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(candidates[i]);

            backtrack(candidates, remains - candidates[i], newPermutation, i, result);
        }
    }
}
