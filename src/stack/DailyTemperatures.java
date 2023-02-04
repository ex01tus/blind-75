package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/daily-temperatures
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> indices = new LinkedList<>();

        for (int current = 0; current < temperatures.length; current++) {
            while (!indices.isEmpty() && temperatures[indices.peek()] < temperatures[current]) {
                int prev = indices.pop();
                result[prev] = current - prev;
            }

            indices.push(current);
        }

        return result;
    }
}
