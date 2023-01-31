package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/kth-largest-element-in-a-stream
 * Difficulty: Easy
 */
public class KthLargestElementInStream {

    private static class KthLargest {

        private final Queue<Integer> minHeap;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
            this.k = k;

            for (int num : nums) {
                add(num);
            }
        }

        /**
         * Time complexity: O(nlog k)
         * Space complexity: O(k)
         */
        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) minHeap.poll();

            return minHeap.peek();
        }

        /**
         * Time complexity: O(nlog k) for val > head, O(1) for val <= head
         * Space complexity: O(k)
         */
        public int addOptimized(int val) {
            if (minHeap.size() < k) {
                minHeap.offer(val);
                return minHeap.peek();
            }

            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            } else {
                // no need to add val <= head
            }

            return minHeap.peek();
        }
    }
}
