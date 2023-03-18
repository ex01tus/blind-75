package array;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/intersection-of-two-arrays-ii
 * Difficulty: Easy
 */
public class IntersectionOfTwoArrays2 {

    /**
     * Time complexity: O(m + n)
     * Space complexity: O(min(m, n))
     */
    public int[] intersectViaFreqMap(int[] small, int[] large) {
        if (small.length > large.length) {
            return intersectViaFreqMap(large, small); // to save memory on freqMap
        }

        Map<Integer, Integer> freqMap = buildFrequencyMap(small);
        List<Integer> intersection = new ArrayList<>();
        for (int num : large) {
            int count = freqMap.getOrDefault(num, 0);
            if (count > 0) {
                intersection.add(num);
                freqMap.merge(num, -1, Integer::sum);
            }
        }

        return intersection.stream().mapToInt(v -> v).toArray();
    }

    private Map<Integer, Integer> buildFrequencyMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        return freqMap;
    }

    /**
     * Time complexity: O(nlog n + mlog m)
     * Space complexity: O(log n + log m)
     */
    public int[] intersectViaSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        List<Integer> intersection = new ArrayList<>();
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] > nums2[second]) {
                second++;
            } else if (nums1[first] < nums2[second]) {
                first++;
            } else {
                intersection.add(nums1[first]);
                first++;
                second++;
            }
        }


        return intersection.stream().mapToInt(v -> v).toArray();
    }
}
