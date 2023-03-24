package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/hand-of-straights
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        Map<Integer, Integer> freqMap = buildFreqMap(hand);

        for (int card : hand) {
            while (freqMap.get(card) > 0) {
                for (int shift = 0; shift < groupSize; shift++) {
                    int count = freqMap.merge(card + shift, -1, Integer::sum);
                    if (count < 0) return false;
                }
            }
        }

        return true;
    }

    private Map<Integer, Integer> buildFreqMap(int[] hand) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int card : hand) {
            freqMap.merge(card, 1, Integer::sum);
        }

        return freqMap;
    }
}
