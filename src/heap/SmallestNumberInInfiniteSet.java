package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/smallest-number-in-infinite-set
 * Difficulty: Medium
 * Time complexity: O(log n) for pop() and add()
 * Space complexity: O(n)
 */
public class SmallestNumberInInfiniteSet {

    private static class SmallestInfiniteSet {

        private final Set<Integer> isPresent; // deduplication
        private final Queue<Integer> minHeap; // smallest element within the added back ones
        private int current; // smallest element in the original set

        public SmallestInfiniteSet() {
            this.isPresent = new HashSet<>();
            this.minHeap = new PriorityQueue<>();
            this.current = 1;
        }

        public int popSmallest() {
            if (!minHeap.isEmpty()) {
                isPresent.remove(minHeap.peek());
                return minHeap.poll();
            }

            return current++;
        }

        public void addBack(int num) {
            if (num >= current || isPresent.contains(num)) return;

            isPresent.add(num);
            minHeap.add(num);
        }
    }
}
