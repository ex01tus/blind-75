package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/degree-of-an-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);
            last.put(nums[i], i);
            freqMap.merge(nums[i], 1, Integer::sum);
        }

        int arrayDegree = Collections.max(freqMap.values());
        int shortest = Integer.MAX_VALUE;
        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == arrayDegree) {
                shortest = Math.min(shortest, last.get(num) - first.get(num) + 1);
            }
        }

        return shortest;
    }
}
