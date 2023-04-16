package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/number-of-equivalent-domino-pairs
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int pairs = 0;

        for (int[] domino : dominoes) {
            // hash
            int value = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);

            // form a pair with each previously seen equivalent
            pairs += freqMap.getOrDefault(value, 0);

            // increment frequency counter
            freqMap.merge(value, 1, Integer::sum);
        }

        return pairs;
    }
}
