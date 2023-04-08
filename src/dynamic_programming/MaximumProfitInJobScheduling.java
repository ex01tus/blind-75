package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/maximum-profit-in-job-scheduling
 * Difficulty: Hard
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = buildJobArraySortedByStartTime(startTime, endTime, profit);
        return findMaxProfit(jobs, 0, new HashMap<>());
    }

    private int findMaxProfit(Job[] jobs, int current, Map<Integer, Integer> memo) {
        if (current == jobs.length) return 0;

        // use memoization to trim recursion tree
        if (memo.containsKey(current)) return memo.get(current);

        // use BS to find the first possible non-conflicting job
        int nextNonConflictingJob = findNextNonConflictingJob(jobs, current);

        // either skip current job and take next or take current and find non-conflicting one
        int skipCurrent = findMaxProfit(jobs, current + 1, memo);
        int takeCurrent = jobs[current].profit + findMaxProfit(jobs, nextNonConflictingJob, memo);
        int maxProfit = Math.max(skipCurrent, takeCurrent);
        memo.put(current, maxProfit);

        return maxProfit;
    }

    private int findNextNonConflictingJob(Job[] jobs, int current) {
        int prevEnd = jobs[current].end;

        int left = 0;
        int right = jobs.length - 1;
        int next = jobs.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].start >= prevEnd) {
                right = mid - 1;
                next = mid;
            } else {
                left = mid + 1;
            }
        }

        return next;
    }

    private Job[] buildJobArraySortedByStartTime(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.start, j2.start));

        return jobs;
    }

    private record Job(int start, int end, int profit) {
    }
}
