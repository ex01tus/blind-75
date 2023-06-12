package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/number-of-recent-calls
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NumberOfRecentCalls {

    private static class RecentCounterViaQueue {

        private final Queue<Integer> hits;

        public RecentCounterViaQueue() {
            this.hits = new LinkedList<>();
        }

        public int ping(int timestamp) {
            hits.offer(timestamp);
            while (!hits.isEmpty() && timestamp - hits.peek() > 3000) {
                hits.poll();
            }

            return hits.size();
        }
    }
}
