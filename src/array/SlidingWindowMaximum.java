package array;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/sliding-window-maximum
 * Difficulty: Hard
 */
public class SlidingWindowMaximum {

    /**
     * Time complexity: O(n)
     * Space complexity: O(k)
     */
    public int[] maxSlidingWindowViaMonotonicDequeWithSingleLoop(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new LinkedList<>(); // head always contains an index of the max value in the window

        for (int current = 0; current < nums.length; current++) {
            // remove leftmost index, that is out of window range
            if (!window.isEmpty() && window.peekFirst() == current - k) {
                window.pollFirst();
            }

            // remove indices, whose corresponding numbers are less or equal than current value
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[current]) {
                window.pollLast();
            }

            // add index of the current value
            window.offerLast(current);

            if (current >= k - 1) {
                result.add(nums[window.peekFirst()]);
            }
        }

        return result.stream().mapToInt(v -> v).toArray();
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(k)
     */
    public int[] maxSlidingWindowViaMonotonicDequeWithTwoLoops(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new LinkedList<>();

        int left = 0;
        int right = 0;
        while (right < k) {
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[right]) {
                window.pollLast();
            }

            window.offerLast(right);

            right++;
        }

        result.add(nums[window.peekFirst()]);

        while (right < nums.length) {
            if (!window.isEmpty() && window.peekFirst() == left) {
                window.pollFirst();
            }

            while (!window.isEmpty() && nums[window.peekLast()] <= nums[right]) {
                window.pollLast();
            }

            window.offerLast(right);
            result.add(nums[window.peekFirst()]);

            left++;
            right++;
        }

        return result.stream().mapToInt(v -> v).toArray();
    }

    /**
     * Time complexity: O(n * k)
     * Space complexity: O(k)
     */
    public int[] maxSlidingWindowViaMaxHeap(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> windowMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int left = 0;
        int right = 0;
        while (right < k) {
            windowMaxHeap.offer(nums[right]);
            right++;
        }
        result.add(windowMaxHeap.peek());

        while (right < nums.length) {
            windowMaxHeap.remove(nums[left]); // iterates through every element and ruins the performance
            windowMaxHeap.offer(nums[right]);

            result.add(windowMaxHeap.peek());

            left++;
            right++;
        }

        return result.stream().mapToInt(v -> v).toArray();
    }

    /**
     * Time complexity: O(n * k)
     * Space complexity: O(k)
     */
    public int[] maxSlidingWindowNaiveApproach(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for (int windowStart = 0; windowStart < nums.length - k + 1; windowStart++) {
            int localMax = Integer.MIN_VALUE;
            for (int shift = 0; shift < k; shift++) {
                localMax = Math.max(localMax, nums[windowStart + shift]);
            }

            result.add(localMax);
        }

        return result.stream().mapToInt(v -> v).toArray();
    }
}
