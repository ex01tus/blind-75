package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/high-five
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class HighFive {

    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> students = new TreeMap<>();
        for (int[] item : items) {
            Queue<Integer> minHeap = students.computeIfAbsent(item[0], __ -> new PriorityQueue<>());
            minHeap.offer(item[1]);
            if (minHeap.size() > 5) minHeap.poll();
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, Queue<Integer>> student : students.entrySet()) {
            Queue<Integer> minHeap = student.getValue();

            int sum = 0;
            while (!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }

            result.add(new int[]{student.getKey(), sum / 5});
        }

        return result.toArray(new int[result.size()][]);
    }
}
