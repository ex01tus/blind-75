package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/third-maximum-number
 * Difficulty: Easy
 */
public class ThirdMaximumNumber {

    /**
     * Time complexity: O(n log3)
     * Space complexity: O(3)
     */
    public int thirdMaxViaMinHeap(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            // skip duplicates
            if (seen.add(num)) {
                minHeap.offer(num);
                if (minHeap.size() > 3) seen.remove(minHeap.poll());
            }
        }

        // skip the secondMax to return the firstMax
        if (minHeap.size() == 2) minHeap.poll();

        return minHeap.poll();
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int thirdMaxViaPointers(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            // skip duplicates
            if (num == firstMax || num == secondMax || num == thirdMax) continue;

            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    }
}
