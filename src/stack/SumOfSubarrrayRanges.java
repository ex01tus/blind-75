package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/sum-of-subarray-ranges
 * Difficulty: Medium
 */
public class SumOfSubarrrayRanges {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public long subArrayRangesViaMonotonicStack(int[] nums) {
        return sumOfMaxs(nums) - sumOfMins(nums);
    }

    private long sumOfMins(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        long sum = 0L;

        for (int right = 0; right <= nums.length; right++) {
            while (!stack.isEmpty() && (right == nums.length || nums[stack.peek()] >= nums[right])) {
                int min = stack.pop();
                int left = !stack.isEmpty() ? stack.peek() : -1;
                long count = (long) (right - min) * (min - left);
                sum += count * nums[min];
            }

            stack.push(right);
        }

        return sum;
    }

    private long sumOfMaxs(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        long sum = 0L;

        for (int right = 0; right <= nums.length; right++) {
            while (!stack.isEmpty() && (right == nums.length || nums[stack.peek()] <= nums[right])) {
                int min = stack.pop();
                int left = !stack.isEmpty() ? stack.peek() : -1;
                long count = (long) (right - min) * (min - left);
                sum += count * nums[min];
            }

            stack.push(right);
        }

        return sum;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public long subArrayRangesViaBruteForce(int[] nums) {
        long sum = 0L;
        for (int start = 0; start < nums.length; start++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int end = start; end < nums.length; end++) {
                min = Math.min(min, nums[end]);
                max = Math.max(max, nums[end]);
                sum += max - min;
            }
        }

        return sum;
    }
}
