package interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/minimum-interval-to-include-each-query
 * Difficulty: Hard
 * Time complexity: O(nlog n + qlog q)
 * Space complexity: O(n + q)
 */
public class MinimalIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        // keep the index to use it while building the result array
        IndexedQuery[] indexedQueries = new IndexedQuery[queries.length];
        for (int i = 0; i < queries.length; i++) {
            indexedQueries[i] = new IndexedQuery(queries[i], i);
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a.val));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int intervalIdx = 0;
        Queue<Interval> minHeap = new PriorityQueue<>(this::compareByLengthThenEnd);
        int[] result = new int[queries.length];

        for (IndexedQuery query : indexedQueries) {
            // add intervals that START BEFORE current query to the heap
            while (intervalIdx < intervals.length && intervals[intervalIdx][0] <= query.val) {
                int[] interval = intervals[intervalIdx];
                int length = interval[1] - interval[0] + 1;

                minHeap.offer(new Interval(length, interval[1]));
                intervalIdx++;
            }

            // pop intervals that END BEFORE current query
            while (!minHeap.isEmpty() && minHeap.peek().end < query.val) {
                minHeap.poll();
            }

            // interval on top of the heap is the shortest one
            result[query.idx] = !minHeap.isEmpty() ? minHeap.peek().length : -1;
        }

        return result;
    }

    private int compareByLengthThenEnd(Interval a, Interval b) {
        int result = Integer.compare(a.length, b.length);
        if (result != 0) return result;

        return Integer.compare(a.end, b.end);
    }

    private record IndexedQuery(int val, int idx) {
    }

    private record Interval(int length, int end) {
    }
}
