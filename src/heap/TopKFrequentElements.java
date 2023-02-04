package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/top-k-frequent-elements
 * Difficulty: Medium
 */
public class TopKFrequentElements {

    /**
     * Time complexity: O(nlog k)
     * Space complexity: O(n + k)
     */
    public int[] topKFrequentViaMinHeap(int[] nums, int k) {
        if (nums.length == k) return nums; // minor optimization

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        int j = 0;
        while (!minHeap.isEmpty()) {
            result[j] = minHeap.poll().getKey();
            j++;
        }

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[] topKFrequentViaBucketSort(int[] nums, int k) {
        if (nums.length == k) return nums; // necessary check

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        List<Integer>[] frequencyBuckets = new List[nums.length];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            int value = entry.getKey();

            if (frequencyBuckets[frequency] == null) {
                frequencyBuckets[frequency] = new ArrayList<>();
            }

            frequencyBuckets[frequency].add(value);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = frequencyBuckets.length - 1; i > 0; i--) {
            if (frequencyBuckets[i] != null) {
                for (int num : frequencyBuckets[i]) {
                    result.add(num);
                    k--;
                    if (k == 0) return result.stream().mapToInt(v -> v).toArray();
                }
            }
        }

        return result.stream().mapToInt(v -> v).toArray();
    }
}
