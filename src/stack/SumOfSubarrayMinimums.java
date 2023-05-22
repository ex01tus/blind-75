package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/sum-of-subarray-minimums
 * Difficulty: Medium
 */
public class SumOfSubarrayMinimums {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int sumSubarrayMinsViaMonotonicStack(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        long sum = 0;

        for (int right = 0; right <= arr.length; right++) {
            while (!stack.isEmpty() && (right == arr.length || arr[stack.peek()] >= arr[right])) {
                int min = stack.pop(); // position of the min element
                int left = !stack.isEmpty() ? stack.peek() : -1; // if stack is empty -> array start is the left boundary

                // 5 6 7 [4] 5 6 -> 4 * 3 = 12
                // 5 6 7 [4] -> 4 possible subarrays with 4 as a min
                // [4] 5 6 -> 3 possible subarrays with 4 as a min
                // - (5,6,7,4) (5,6,7,4,5) (5,6,7,4,5,6) -> +3
                // - (6,7,4) (6,7,4,5) (6,7,4,5,6) -> +3
                // - (7,4) (7,4,5) (7,4,5,6) -> +3
                // - (4) (4,5) (4,5,6) -> +3
                // 4 * 3 = 12
                long subarraysCount = (long) (right - min) * (min - left);
                sum += arr[min] * subarraysCount;
                sum %= MOD;
            }

            stack.push(right);
        }

        return (int) sum;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int sumSubarrayMinsViaBruteForce(int[] arr) {
        int sum = 0;
        for (int start = 0; start < arr.length; start++) {
            int min = Integer.MAX_VALUE;
            for (int end = start; end < arr.length; end++) {
                min = Math.min(min, arr[end]);
                sum += min;
                sum %= MOD;
            }
        }

        return sum;
    }
}
