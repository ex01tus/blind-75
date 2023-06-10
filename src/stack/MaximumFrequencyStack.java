package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/maximum-frequency-stack
 * Difficulty: Hard
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class MaximumFrequencyStack {

    private static class FreqStack {

        private final Map<Integer, Integer> valToFreqMap;
        private final Map<Integer, Deque<Integer>> freqToStackMap;
        private int maxFreq;

        public FreqStack() {
            this.valToFreqMap = new HashMap<>();
            this.freqToStackMap = new HashMap<>();
            this.maxFreq = 1;
        }

        public void push(int val) {
            int frequency = valToFreqMap.getOrDefault(val, 0) + 1;
            if (frequency > maxFreq) maxFreq = frequency;
            valToFreqMap.put(val, frequency);
            freqToStackMap.computeIfAbsent(frequency, __ -> new LinkedList<>()).push(val);
        }

        public int pop() {
            Deque<Integer> stack = freqToStackMap.get(maxFreq);
            int val = stack.pop();
            if (stack.isEmpty()) maxFreq--;
            valToFreqMap.merge(val, -1, Integer::sum);

            return val;
        }
    }
}
