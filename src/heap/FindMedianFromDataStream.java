package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/find-median-from-data-stream
 * Difficulty: Hard
 * Time complexity: O(log n) for addNum() and O(1) for findMedian()
 * Space complexity: O(n)
 */
public class FindMedianFromDataStream {

    private static class MedianFinder {

        private final Queue<Integer> lowerHalfMaxHeap;
        private final Queue<Integer> upperHalfMinHeap;

        public MedianFinder() {
            this.lowerHalfMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            this.upperHalfMinHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // add new element to the upper half
            upperHalfMinHeap.offer(num);

            // numbers in the lower half should be less, than the numbers in the upper one
            int upperHalfMin = upperHalfMinHeap.poll();
            lowerHalfMaxHeap.offer(upperHalfMin);

            // balance two heaps, so that the second one is always has equal or greater size, than the first
            if (lowerHalfMaxHeap.size() > upperHalfMinHeap.size()) {
                upperHalfMinHeap.offer(lowerHalfMaxHeap.poll());
            }
        }

        public double findMedian() {
            if (lowerHalfMaxHeap.size() == upperHalfMinHeap.size()) { // even number of elements
                return (lowerHalfMaxHeap.peek() + upperHalfMinHeap.peek()) / 2.0;
            }

            return (double) upperHalfMinHeap.peek(); // odd number of elements
        }
    }
}
