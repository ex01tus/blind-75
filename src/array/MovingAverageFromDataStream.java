package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/moving-average-from-data-stream
 * Difficulty: Easy
 * Time complexity: O(1)
 * Space complexity: O(m)
 */
public class MovingAverageFromDataStream {

    private static class MovingAverageViaDeque {

        private final Deque<Integer> window;
        private final int maxWindowSize;
        private int windowSum;

        public MovingAverageViaDeque(int size) {
            this.window = new LinkedList<>();
            this.maxWindowSize = size;
        }

        public double next(int val) {
            windowSum += val;
            window.offerLast(val);
            if (window.size() > maxWindowSize) {
                windowSum -= window.pollFirst();
            }

            return (double) windowSum / window.size();
        }
    }

    private static class MovingAverageViaRingBuffer {

        private final int[] window;
        private int current;
        private int windowSum;
        private int count;

        public MovingAverageViaRingBuffer(int size) {
            this.window = new int[size];
        }

        public double next(int val) {
            count++;
            windowSum = windowSum - window[current] + val;
            window[current] = val;
            current = (current + 1) % window.length;

            return (double) windowSum / Math.min(count, window.length);
        }
    }
}
