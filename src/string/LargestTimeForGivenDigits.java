package string;

/**
 * Description: https://leetcode.com/problems/largest-time-for-given-digits
 * Difficulty: Medium
 * Time complexity: O(4*4*4) -> O (1)
 * Space complexity: O(1)
 */
public class LargestTimeForGivenDigits {

    public String largestTimeFromDigits(int[] arr) {
        int maxTime = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i == j || j == k || i == k) continue; // no duplicated digits

                    int l = 6 - i - j - k; // for 4 digits sum of indices is 0 + 1 + 2 + 3 = 6
                    int hour = arr[i] * 10 + arr[j];
                    int minute = arr[k] * 10 + arr[l];
                    if (hour < 24 && minute < 60) {
                        maxTime = Math.max(maxTime, hour * 60 + minute);
                    }
                }
            }
        }

        if (maxTime == Integer.MIN_VALUE) {
            return "";
        }

        return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }
}
