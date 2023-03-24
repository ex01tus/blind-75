package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/design-hit-counter
 * Difficulty: Medium
 */
public class DesignHitCounter {

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    private static class HitCounterViaRingBuffer {

        private static final int LIMIT = 300;

        private final int[] hits;
        private int last;

        public HitCounterViaRingBuffer() {
            this.hits = new int[LIMIT];
            this.last = 0;
        }

        public void hit(int timestamp) {
            move(timestamp);
            hits[timestamp % LIMIT]++;
        }

        public int getHits(int timestamp) {
            move(timestamp);
            return count();
        }

        private void move(int timestamp) {
            int gap = Math.min(timestamp - last, LIMIT);
            for (int i = 0; i < gap; i++) {
                hits[(last + 1 + i) % LIMIT] = 0;
            }

            last = timestamp;
        }

        // lazily count hits number only on `getHits()` call
        private int count() {
            int sum = 0;
            for (int hit : hits) {
                sum += hit;
            }

            return sum;
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private static class HitCounterViaQueue {

        private final Queue<Integer> hits;

        public HitCounterViaQueue() {
            this.hits = new LinkedList<>();
        }

        public void hit(int timestamp) {
            hits.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while (!hits.isEmpty() && timestamp - hits.peek() >= 300) {
                hits.poll();
            }

            return hits.size();
        }
    }
}
