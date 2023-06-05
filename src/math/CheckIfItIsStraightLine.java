package math;

/**
 * Description: https://leetcode.com/problems/check-if-it-is-a-straight-line
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class CheckIfItIsStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        double slope = getSlope(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (getSlope(coordinates[i], coordinates[i - 1]) != slope) return false;
        }

        return true;
    }

    private double getSlope(int[] point1, int[] point2) {
        if (point1[0] == point2[0]) return Double.POSITIVE_INFINITY;
        if (point1[1] == point2[1]) return 0.0;

        return (double) (point1[1] - point2[1]) / (point1[0] - point2[0]);
    }
}
