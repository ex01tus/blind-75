package interval;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/non-overlapping-intervals
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(1)
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int end = intervals[0][1];
        int nonOverlappingIntervals = 1;
        for (int[] current : intervals) {
            if (current[0] >= end) {
                nonOverlappingIntervals++;
                end = current[1];
            } else {
                end = Math.min(end, current[1]);
            }
        }

        return intervals.length - nonOverlappingIntervals;
    }
}
