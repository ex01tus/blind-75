package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/top-k-frequent-words
 * Difficulty: Medium
 * Time complexity: O(nlog k)
 * Space complexity: O(n)
 */
public class TopKFrequentWords {

    public List<String> topKFrequentViaMaxHeap(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.merge(word, 1, Integer::sum);
        }

        // easier to meet sorting requirements, but O(n) space for the heap
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> compareMax(a, b));
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(entry);
        }

        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(maxHeap.poll().getKey());
            k--;
        }

        return  result;
    }

    private int compareMax(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        int result = Integer.compare(b.getValue(), a.getValue());
        return result != 0
                ? result
                : a.getKey().compareTo(b.getKey());
    }

    public List<String> topKFrequentViaMinHeap(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.merge(word, 1, Integer::sum);
        }

        // tricky sorting, but O(k) space for the heap
        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> compareMin(a, b));
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }

        return  result;
    }

    private int compareMin(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        int result = Integer.compare(a.getValue(), b.getValue());
        return result != 0
                ? result
                : b.getKey().compareTo(a.getKey());
    }
}
