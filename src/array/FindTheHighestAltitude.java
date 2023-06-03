package array;

/**
 * Description: https://leetcode.com/problems/find-the-highest-altitude
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindTheHighestAltitude {

    public int largestAltitude(int[] gains) {
        int largest = 0;
        int altitude = 0;

        for (int gain : gains) {
            altitude += gain;
            largest = Math.max(largest, altitude);
        }

        return largest;
    }
}
