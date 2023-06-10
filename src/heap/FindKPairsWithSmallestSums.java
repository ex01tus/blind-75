package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 * Difficulty: Medium
 */
public class FindKPairsWithSmallestSums {

    /**
     * Time complexity: O(klog k)
     * Space complexity: O(k)
     */
    public List<List<Integer>> kSmallestPairsOptimalApproach(int[] nums1, int[] nums2, int k) {
        Queue<Tuple> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.first + a.second));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new Tuple(nums1[i], nums2[0], 0));
        }

        List<List<Integer>> pairs = new ArrayList<>();
        while (!minHeap.isEmpty() && pairs.size() < k) {
            Tuple current = minHeap.poll();
            pairs.add(List.of(current.first, current.second));

            if (current.index < nums2.length - 1) {
                minHeap.offer(new Tuple(current.first, nums2[current.index + 1], current.index + 1));
            }
        }

        return pairs;
    }

    private record Tuple(int first, int second, int index) {
    }

    /**
     * Time complexity: O(n * m * log k)
     * Space complexity: O(k)
     */
    public List<List<Integer>> kSmallestPairsNaiveApproach(int[] nums1, int[] nums2, int k) {
        Queue<List<Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.get(0) + b.get(1), a.get(0) + a.get(1)));

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                maxHeap.offer(List.of(num1, num2));
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }
}
