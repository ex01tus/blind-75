package greedy;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;

        Arrays.sort(nums);
        // can use TreeMap, avoid array sorting and iterate through freqMap.keySet()
        Map<Integer, Integer> freqMap = buildFreqMap(nums);

        for (int num : nums) {
            while (freqMap.get(num) > 0) {
                for (int shift = 0; shift < k; shift++) {
                    int count = freqMap.merge(num + shift, -1, Integer::sum);
                    if (count < 0) return false;
                }
            }
        }

        return true;
    }

    private Map<Integer, Integer> buildFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        return freqMap;
    }
}
