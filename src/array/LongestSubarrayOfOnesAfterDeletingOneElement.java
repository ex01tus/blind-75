package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
 * Difficulty: Medium
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int removalsLeft = 1;

        while (right < nums.length) {
            if (nums[right] == 0) removalsLeft--;
            if (removalsLeft < 0) {
                if (nums[left] == 0) removalsLeft++;
                left++;
            }

            right++;
        }

        return right - left - 1;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(k)
     */
    public int longestSubarrayForDataStream(int[] nums) {
        int left = 0;
        int longest = 0;
        Queue<Integer> zeroes = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes.offer(right);
            if (zeroes.size() > 1) {
                left = zeroes.poll() + 1;
            }

            longest = Math.max(longest, right - left);
        }

        return longest;
    }
}
