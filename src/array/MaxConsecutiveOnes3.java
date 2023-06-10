package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/max-consecutive-ones-iii
 * Difficulty: Medium
 */
public class MaxConsecutiveOnes3 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) k--;
            if (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }

            right++;
        }

        return right - left;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(k)
     */
    public int longestOnesForDataStream(int[] nums, int k) {
        int left = 0;
        int max = 0;

        Queue<Integer> zeroPositions = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroPositions.offer(right);
            if (zeroPositions.size() > k) {
                left = zeroPositions.poll() + 1;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
