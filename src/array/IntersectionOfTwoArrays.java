package array;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/intersection-of-two-arrays
 * Difficulty: Easy
 */
public class IntersectionOfTwoArrays {

    /**
     * Time complexity: O(m + n)
     * Space complexity: O(min(m, n))
     */
    public int[] intersectionViaSet(int[] small, int[] large) {
        if (small.length > large.length) {
            return intersectionViaSet(large, small);
        }

        Set<Integer> smallSet = new HashSet<>();
        for (int num : small) {
            smallSet.add(num);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : large) {
            if (smallSet.remove(num)) {
                intersection.add(num);
            }
        }

        return intersection.stream().mapToInt(v -> v).toArray();
    }

    /**
     * Time complexity: O(nlog n + mlog m)
     * Space complexity: O(log n + log m)
     */
    public int[] intersectionViaSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        Set<Integer> intersection = new HashSet<>();
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
