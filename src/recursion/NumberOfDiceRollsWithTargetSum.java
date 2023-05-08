package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
 * Difficulty: Medium
 * Time complexity: O(dices * faces * target)
 * Space complexity: O(dices * target)
 */
public class NumberOfDiceRollsWithTargetSum {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int dices, int faces, int target) {
        return count(dices, faces, target, new HashMap<>());
    }

    private int count(int dicesLeft, int faces, int remains, Map<String, Integer> memo) {
        if (remains > dicesLeft * faces || remains < dicesLeft) return 0;
        if (remains == 0 && dicesLeft == 0) return 1;

        String dicesToRemainsKey = dicesLeft + ":" + remains;
        if (memo.containsKey(dicesToRemainsKey)) {
            return memo.get(dicesToRemainsKey);
        }

        int count = 0;
        for (int face = 1; face <= faces; face++) {
            count += count(dicesLeft - 1, faces, remains - face, memo);
            count %= MOD;
        }

        memo.put(dicesToRemainsKey, count);

        return count;
    }
}
