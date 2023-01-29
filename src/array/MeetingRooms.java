package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/meeting-rooms
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(1)
 */
public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }

    private static class Interval {
        int start;
        int end;
    }
}
