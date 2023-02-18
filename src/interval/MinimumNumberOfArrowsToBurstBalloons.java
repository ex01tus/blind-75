package interval;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(1)
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) return points.length;

        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));

        int end = points[0][1];
        int nonOverlapingIntervals = 1;

        for (int[] point : points) {
            if (point[0] > end) {
                nonOverlapingIntervals++;
                end = point[1];
            } else {
                end = Math.min(end, point[1]);
            }
        }

        return nonOverlapingIntervals;
    }
}
