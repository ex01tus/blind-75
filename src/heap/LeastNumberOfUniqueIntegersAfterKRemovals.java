package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public int findLeastNumOfUniqueIntsViaMinHeap(int[] arr, int k) {
        Map<Integer, Integer> freqMap = buildFreqMap(arr);
        Queue<Map.Entry<Integer, Integer>> minHeap = buildHeap(freqMap);

        while (k > 0) {
            k -= minHeap.poll().getValue();
        }

        return k < 0 ? minHeap.size() + 1 : minHeap.size();
    }

    private Queue<Map.Entry<Integer, Integer>> buildHeap(Map<Integer, Integer> freqMap) {
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            minHeap.offer(e);
        }
        return minHeap;
    }

    public int findLeastNumOfUniqueIntsViaSorting(int[] arr, int k) {
        Map<Integer, Integer> freqMap = buildFreqMap(arr);
        List<Integer> sortedByFreq = getNumbersSortedByFreq(freqMap);

        int pointer = 0;
        int removed = 0;
        while (k > 0 && pointer < sortedByFreq.size()) {
            int num = sortedByFreq.get(pointer);
            k -= freqMap.get(num);

            if (k >= 0) removed++;

            pointer++;
        }

        return sortedByFreq.size() - removed;
    }

    private Map<Integer, Integer> buildFreqMap(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.merge(num, 1, Integer::sum);
        }

        return freqMap;
    }

    private List<Integer> getNumbersSortedByFreq(Map<Integer, Integer> freqMap) {
        return new ArrayList<>(freqMap.entrySet()).stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toList();
    }
}
