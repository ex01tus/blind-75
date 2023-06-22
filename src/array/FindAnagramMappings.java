package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-anagram-mappings
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FindAnagramMappings {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            numToIndex.put(nums2[i], i);
        }

        int[] mappings = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            mappings[i] = numToIndex.get(nums1[i]);
        }

        return mappings;
    }
}
