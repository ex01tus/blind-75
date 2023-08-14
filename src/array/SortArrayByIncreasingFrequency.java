package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/sort-array-by-increasing-frequency
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = buildFreqMap(nums);
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> compare(a, b, freqMap))
                .mapToInt(v -> v)
                .toArray();
    }

    private Map<Integer, Integer> buildFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        return freqMap;
    }

    private int compare(int a, int b, Map<Integer, Integer> freqMap) {
        int result = Integer.compare(freqMap.get(a), freqMap.get(b));
        return result != 0 ? result : Integer.compare(b, a);
    }
}
