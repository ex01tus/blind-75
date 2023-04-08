package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/height-checker
 * Difficulty: Easy
 */
public class HeightChecker {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int heightCheckerViaCountingSort(int[] heights) {
        int[] freqMap = new int[101];
        for (int height : heights) {
            freqMap[height]++;
        }

        int mismatch = 0;
        int currentHeight = 1;
        for (int height : heights) {
            while (freqMap[currentHeight] == 0) {
                currentHeight++;
            }

            if (height != currentHeight) {
                mismatch++;
            }

            freqMap[currentHeight]--;
        }

        return mismatch;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(n)
     */
    public int heightCheckerViaSorting(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);

        int mismatch = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) mismatch++;
        }

        return mismatch;
    }
}
