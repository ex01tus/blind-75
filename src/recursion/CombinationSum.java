package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/combination-sum
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
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
            List<Integer> currentPermutation,
            int start,
            List<List<Integer>> result) {
        if (remains < 0) return;

        if (remains == 0) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentPermutation.add(candidates[i]);
            backtrack(candidates, remains - candidates[i], currentPermutation, i, result);
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
