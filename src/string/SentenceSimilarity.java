package string;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/sentence-similarity
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SentenceSimilarity {

    public boolean areSentencesSimilar(
            String[] sentence1,
            String[] sentence2,
            List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> similar = buildSimilarityMap(similarPairs);

        for (int i = 0; i < sentence1.length; i++) {
            String first = sentence1[i];
            String second = sentence2[i];

            if (first.equals(second)) continue;

            if (!similar.containsKey(first) || !similar.get(first).contains(second)) {
                return false;
            }
        }

        return true;
    }

    private Map<String, Set<String>> buildSimilarityMap(List<List<String>> similarPairs) {
        Map<String, Set<String>> similar = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String first = pair.get(0);
            String second = pair.get(1);

            similar.computeIfAbsent(first, __ -> new HashSet<>()).add(second);
            similar.computeIfAbsent(second, __ -> new HashSet<>()).add(first);
        }

        return similar;
    }
}
