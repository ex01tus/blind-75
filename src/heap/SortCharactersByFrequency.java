package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/sort-characters-by-frequency
 * Difficulty: Medium
 */
public class SortCharactersByFrequency {

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(n)
     */
    public String frequencySortViaMaxHeap(String s) {
        Map<Character, Integer> freqMap = buildFreqMap(s);

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder sorted = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sorted.append(entry.getKey());
            }
        }

        return sorted.toString();
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public String frequencySortViaBucketSort(String s) {
        Map<Character, Integer> freqMap = buildFreqMap(s);
        List<List<Character>> freqBuckets = buildFreqBuckets(freqMap);

        StringBuilder sorted = new StringBuilder();
        for (int freq = freqBuckets.size() - 1; freq > 0; freq--) {
            List<Character> bucket = freqBuckets.get(freq);
            for (char c : bucket) {
                for (int i = 0; i < freq; i++) {
                    sorted.append(c);
                }
            }
        }

        return sorted.toString();
    }

    private Map<Character, Integer> buildFreqMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.merge(c, 1, Integer::sum);
        }
        return freqMap;
    }

    private List<List<Character>> buildFreqBuckets(Map<Character, Integer> freqMap) {
        int maxFreq = Collections.max(freqMap.values());
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        return buckets;
    }
}
