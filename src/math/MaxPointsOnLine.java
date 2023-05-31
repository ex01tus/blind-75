package math;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/max-points-on-a-line
 * Difficulty: Hard
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class MaxPointsOnLine {

    private static final double SAME_X = Double.POSITIVE_INFINITY; // (y1 - y2) / 0
    private static final double SAME_Y = 0.0; // 0 / (x1 - x2)

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int globalMax = 0;
        for (int i = 0; i < points.length; i++) {
            // count points for each line, starting in point1
            Map<Double, Integer> slopesToPointsCount = new HashMap<>();
            int[] point1 = points[i];
            int localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                double slope = findSlope(point1, point2);

                // count 2 points when first encountering the line, then add 1 point every time
                slopesToPointsCount.putIfAbsent(slope, 1);
                int count = slopesToPointsCount.merge(slope, 1, Integer::sum);

                // update localMax not to iterate through slopesToPointsCount one more time later on
                localMax = Math.max(localMax, count);
            }

            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

    // (y1 - y2) / (x1 - x2)
    private double findSlope(int[] point1, int[] point2) {
        if (point1[0] == point2[0]) return SAME_X;
        if (point1[1] == point2[1]) return SAME_Y;

        return (double) (point1[1] - point2[1]) / (point1[0] - point2[0]);
    }
}
