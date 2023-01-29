package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/combination-sum-ii
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates, 0, new ArrayList<>(), target, combinations);

        return combinations;
    }

    private void backtrack(
            int[] candidates,
            int start,
            List<Integer> combination,
            int remains,
            List<List<Integer>> result) {
        if (remains < 0) return;

        if (remains == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            combination.add(candidates[i]);
            backtrack(candidates, i + 1, combination, remains - candidates[i], result);
            combination.remove(combination.size() - 1);
        }
    }
}
