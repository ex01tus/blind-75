package interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/meeting-rooms
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(1)
 */
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
