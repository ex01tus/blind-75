package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/max-consecutive-ones-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int flips = 1;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) flips--;
            if (flips < 0) {
                if (nums[left] == 0) flips++;
                left++;
            }

            right++;
        }

        return right - left;
    }

    public int findMaxConsecutiveOnesForDataStream(int[] nums) {
        int flips = 1;
        int left = 0;
        int max = 0;

        Queue<Integer> zeroPositions = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroPositions.offer(right);
            if (zeroPositions.size() > flips) {
                left = zeroPositions.poll() + 1;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
