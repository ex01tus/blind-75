package interval;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/meeting-rooms-ii
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class MeetingRooms2 {

    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int startPointer = 0;
        int endPointer = 0;
        int busyRoomsCount = 0;
        int maxCount = 0;

        while (startPointer < starts.length) {
            if (starts[startPointer] < ends[endPointer]) { // a new meeting has started, while the previous one didn't end
                busyRoomsCount++;
                startPointer++;
            } else { // a meeting has ended
                busyRoomsCount--;
                endPointer++;
            }

            maxCount = Math.max(busyRoomsCount, maxCount);
        }

        return maxCount;
    }

    private static class Interval {
        int start;
        int end;
    }
}
