package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/maximum-subsequence-score
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] nums = toPairsSortedByNum2Desc(nums1, nums2);

        Queue<Integer> minHeap = new PriorityQueue<>(Integer::compare);
        long topKSum = 0L;
        long maxScore = 0L;

        for (int i = 0; i < nums.length; i++) {
            // - nums are sorted in descending order by nums2 value
            // - all the elements to the left of `i` won't change the minVal
            // - find `k` maximum elements prior to `i` and multiply their sum by minVal
            topKSum += nums[i].num1;
            minHeap.offer(nums[i].num1);
            if (i >= k) {
                // window is to big -> remove the smallest element
                topKSum -= minHeap.poll();
            }

            if (i >= k - 1) {
                // window was built -> start tracking the maxScore
                long currentScore = topKSum * nums[i].num2;
                maxScore = Math.max(maxScore, currentScore);
            }
        }

        return maxScore;
    }

    private static Pair[] toPairsSortedByNum2Desc(int[] nums1, int[] nums2) {
        Pair[] nums = new Pair[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(b.num2, a.num2));
        return nums;
    }

    private record Pair(int num1, int num2) {
    }
}
