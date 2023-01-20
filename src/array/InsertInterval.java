package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/insert-interval
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class InsertInterval {

    public int[][] insertWithThreeLoops(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // insert all intervals before the new one to the left
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }

        // merge overlaps
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // insert all the rest intervals to the right
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][]);
    }

    public int[][] insertWithSingleLoop(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] slot : intervals) {
            if (newInterval[1] < slot[0]) {
                // newInterval goes on the left
                result.add(newInterval);
                newInterval = slot;
            } else if (newInterval[0] > slot[1]) {
                // newInterval goes on the right
                result.add(slot);
            } else {
                // overlap
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[0][]);
    }
}
