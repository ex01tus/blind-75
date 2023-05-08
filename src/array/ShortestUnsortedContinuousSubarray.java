package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/shortest-unsorted-continuous-subarray
 * Difficulty: Medium
 */
public class ShortestUnsortedContinuousSubarray {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int findUnsortedSubarrayViaMonotonicStacks(int[] nums) {
        int left = nums.length;
        int right = 0;

        Deque<Integer> stack = new LinkedList<>();
        for (int l = 0; l < nums.length; l++) {
            while (!stack.isEmpty() && nums[l] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }

            stack.push(l);
        }

        stack.clear();

        for (int r = nums.length - 1; r >= 0; r--) {
            while (!stack.isEmpty() && nums[r] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }

            stack.push(r);
        }

        return right - left < 0 ? 0 : right - left + 1;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(n)
     */
    public int findUnsortedSubarrayViaSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int left = nums.length;
        int right = 0;

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != nums[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }

        return right - left < 0 ? 0 : right - left + 1;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int findUnsortedSubarrayViaTwoLoops(int[] nums) {
        int left = nums.length;
        int right = 0;

        for (int l = 0; l < nums.length; l++) {
            for (int r = l + 1; r < nums.length; r++) {
                if (nums[l] > nums[r]) {
                    left = Math.min(left, l);
                    right = Math.max(right, r);
                }
            }
        }

        return right - left < 0 ? 0 : right - left + 1;
    }
}
