package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/total-cost-to-hire-k-workers
 * Difficulty: Medium
 * Time complexity: O((c + k) * log c)
 * Space complexity: O(c)
 */
public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Worker> minHeap = new PriorityQueue<>(this::compareWorkers);
        int left = 0;
        int right = costs.length - 1;
        while (left < costs.length && minHeap.size() < candidates) {
            minHeap.offer(new Worker(left, costs[left], true));
            left++;
        }

        while (left < right && minHeap.size() < candidates * 2) {
            minHeap.offer(new Worker(right, costs[right], false));
            right--;
        }

        long totalCost = 0L;
        while (!minHeap.isEmpty() && k > 0) {
            Worker hired = minHeap.poll();
            totalCost += hired.cost;
            k--;

            if (left > right) continue;

            if (hired.isHead) {
                minHeap.offer(new Worker(left, costs[left], true));
                left++;
            } else {
                minHeap.offer(new Worker(right, costs[right], false));
                right--;
            }
        }

        return totalCost;
    }

    private int compareWorkers(Worker a, Worker b) {
        int result = Integer.compare(a.cost, b.cost);
        if (result != 0) return result;
        return Integer.compare(a.index, b.index);
    }

    private record Worker(int index, int cost, boolean isHead) {
    }
}
