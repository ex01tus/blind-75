package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/reorganize-string
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReorganizeString {

    public String reorganizeString(String s) {
        Map<Character, Integer> frequencyMap = buildFrequencyMap(s);
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder possibleRearrangement = new StringBuilder();
        while (maxHeap.size() > 1) {
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();

            possibleRearrangement
                    .append(first.getKey())
                    .append(second.getKey());

            int firstLeft = first.getValue();
            if (firstLeft > 1) {
                first.setValue(firstLeft - 1);
                maxHeap.offer(first);
            }

            int secondLeft = second.getValue();
            if (secondLeft > 1) {
                second.setValue(secondLeft);
                maxHeap.offer(second);
            }
        }

        if (!maxHeap.isEmpty()) {
            if (maxHeap.peek().getValue() > 1) {
                return "";
            } else {
                possibleRearrangement.append(maxHeap.poll().getKey());
            }
        }

        return possibleRearrangement.toString();
    }

    private Map<Character, Integer> buildFrequencyMap(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.merge(c, 1, Integer::sum);
        }

        return frequencyMap;
    }
}
