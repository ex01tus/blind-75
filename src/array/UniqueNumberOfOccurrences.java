package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/unique-number-of-occurrences
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.merge(num, 1, Integer::sum);
        }

        Set<Integer> seenFreqs = new HashSet<>();
        for (int freq : freqMap.values()) {
            if (!seenFreqs.add(freq)) return false;
        }

        return true;
    }
}
