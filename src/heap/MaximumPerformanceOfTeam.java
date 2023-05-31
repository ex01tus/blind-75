package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/maximum-performance-of-a-team
 * Difficulty: Hard
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class MaximumPerformanceOfTeam {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engineers = toEngineersSortedByEfficiencyDesc(speed, efficiency);

        Queue<Integer> minHeap = new PriorityQueue<>(Integer::compare);
        long topKSpeedSum = 0L;
        long maxPerformance = 0L;

        for (int i = 0; i < engineers.length; i++) {
            // - engineers are sorted in descending order by efficiency value
            // - all the elements to the left of `i` won't change the minEfficiency
            // - find `k` maximum elements prior to `i` and multiply their sum by minEfficiency
            topKSpeedSum += engineers[i].speed;
            minHeap.offer(engineers[i].speed);
            if (i >= k) {
                // window is to big -> remove the smallest element
                topKSpeedSum -= minHeap.poll();
            }

            // we are looking for AT MOST k engineers -> start tracking the maxPerformance right away
            long currentPerformance = topKSpeedSum * engineers[i].efficiency;
            maxPerformance = Math.max(maxPerformance, currentPerformance);
        }

        return (int) (maxPerformance % MOD);
    }

    private Engineer[] toEngineersSortedByEfficiencyDesc(int[] speed, int[] efficiency) {
        Engineer[] engineers = new Engineer[speed.length];
        for (int i = 0; i < speed.length; i++) {
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }
        Arrays.sort(engineers, (a, b) -> Integer.compare(b.efficiency, a.efficiency));

        return engineers;
    }

    private record Engineer(int speed, int efficiency) {
    }
}
