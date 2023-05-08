package math;

/**
 * Description: https://leetcode.com/problems/minimum-time-visiting-all-points
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length < 2) return 0;

        int distance = 0;
        for (int current = 1; current < points.length; current++) {
            distance += chebyshevDistance(points[current - 1], points[current]);
        }

        return distance;
    }

    // greedily move diagonally
    private int chebyshevDistance(int[] a, int[] b) {
        return Math.max(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1]));
    }
}
