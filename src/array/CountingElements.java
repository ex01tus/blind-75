package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/counting-elements
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CountingElements {

    public int countElementsViaSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            seen.add(num);
        }

        int count = 0;
        for (int num : arr) {
            if (seen.contains(num + 1)) count++;
        }

        return count;
    }

    public int countElementsViaFreqMap(int[] arr) {
        int[] freqMap = new int[1001];
        for (int num : arr) {
            freqMap[num]++;
        }

        int count = 0;
        for (int i = 0; i < freqMap.length - 1; i++) {
            if (freqMap[i + 1] > 0) count += freqMap[i];
        }

        return count;
    }
}
