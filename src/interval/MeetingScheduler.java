package interval;

import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/meeting-scheduler
 * Difficulty: Medium
 * Time complexity: O(nlog n + mlog m)
 * Space complexity: O(log n + log m)
 */
public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (s1, s2) -> Integer.compare(s1[0], s2[0]));
        Arrays.sort(slots2, (s1, s2) -> Integer.compare(s1[0], s2[0]));

        int first = 0;
        int second = 0;

        while (first < slots1.length && second < slots2.length) {
            int[] firstSlot = slots1[first];
            int[] secondSlot = slots2[second];

            int leftIntersectionBound = Math.max(firstSlot[0], secondSlot[0]);
            int rightIntersectionBound = Math.min(firstSlot[1], secondSlot[1]);
            int intersectionLength = rightIntersectionBound - leftIntersectionBound;

            if (intersectionLength >= duration) {
                return List.of(leftIntersectionBound, leftIntersectionBound + duration);
            }

            // find the slot that ends earlier
            if (firstSlot[1] < secondSlot[1]) {
                first++;
            } else {
                second++;
            }
        }

        return List.of();
    }
}
