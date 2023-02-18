package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/merge-intervals
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> result = new ArrayList<>();
        for (int[] current : intervals) {
            if (current[0] > end) {
                result.add(new int[]{start, end});
                start = current[0];
                end = current[1];
            } else {
                end = Math.max(current[1], end);
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[0][]);
    }
}
