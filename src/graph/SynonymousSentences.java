package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/synonymous-sentences
 * Difficulty: Medium
 */
public class SynonymousSentences {

    private final Map<String, String> parents = new HashMap<>();
    private final Map<String, Integer> ranks = new HashMap<>();

    /**
     * Time complexity: O(?)
     * Space complexity: O(?)
     */
    public List<String> generateSentencesViaUnionFind(List<List<String>> synonyms, String text) {
        Set<String> wordsWithSynonyms = new HashSet<>();
        for (List<String> pair : synonyms) {
            unite(pair.get(0), pair.get(1));
            wordsWithSynonyms.add(pair.get(0));
            wordsWithSynonyms.add(pair.get(1));
        }

        String[] words = text.split(" ");
        Map<String, Set<String>> synonymGroups = buildSynonymGroups(words, wordsWithSynonyms);

        List<String> result = new ArrayList<>();
        backtrack(words, synonymGroups, 0, new String[words.length], result);
        Collections.sort(result);
        return result;
    }

    private String findParent(String word) {
        parents.putIfAbsent(word, word);

        while (!word.equals(parents.get(word))) {
            parents.put(word, parents.get(parents.get(word)));
            word = parents.get(word);
        }

        return word;
    }

    private void unite(String word1, String word2) {
        String parent1 = findParent(word1);
        String parent2 = findParent(word2);

        if (parent1.equals(parent2)) return;

        int rank1 = ranks.getOrDefault(parent1, 1);
        int rank2 = ranks.getOrDefault(parent2, 1);
        if (rank1 > rank2) {
            parents.put(parent2, parent1);
            ranks.put(parent1, rank1 + rank2);
        } else {
            parents.put(parent1, parent2);
            ranks.put(parent2, rank2 + rank1);
        }
    }

    private boolean areConnected(String word1, String word2) {
        String parent1 = findParent(word1);
        String parent2 = findParent(word2);

        return parent1.equals(parent2);
    }

    private Map<String, Set<String>> buildSynonymGroups(String[] words, Set<String> wordsWithSynonyms) {
        Map<String, Set<String>> wordGroups = new HashMap<>();
        for (String word : words) {
            for (String unique : wordsWithSynonyms) {
                if (areConnected(word, unique)) {
                    wordGroups.computeIfAbsent(word, __ -> new HashSet<>()).add(unique);
                }
            }
        }

        return wordGroups;
    }

    private void backtrack(
            String[] text,
            Map<String, Set<String>> synonyms,
            int current,
            String[] currentSentence,
            List<String> result) {
        if (current == text.length) {
            result.add(String.join(" ", currentSentence));
            return;
        }

        for (String synonym : synonyms.getOrDefault(text[current], Set.of(text[current]))) {
            currentSentence[current] = synonym;
            backtrack(text, synonyms, current + 1, currentSentence, result);
        }
    }

    /**
     * Time complexity: O(?)
     * Space complexity: O(?)
     */
    public List<String> generateSentencesViaBFS(List<List<String>> synonyms, String text) {
        Map<String, List<String>> adjList = buildAdjList(synonyms);

        Set<String> result = new TreeSet<>();
        Queue<String> planned = new LinkedList<>();
        planned.offer(text);

        while (!planned.isEmpty()) {
            String current = planned.poll();
            result.add(current);

            String[] words = current.split(" ");
            for (int i = 0; i < words.length; i++) {
                for (String synonym : adjList.getOrDefault(words[i], List.of())) {
                    words[i] = synonym;
                    String newSentence = String.join(" ", words);
                    if (!result.contains(newSentence)) {
                        planned.offer(newSentence);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    private Map<String, List<String>> buildAdjList(List<List<String>> synonyms) {
        Map<String, List<String>> adjList = new HashMap<>();
        for (List<String> pair : synonyms) {
            adjList.computeIfAbsent(pair.get(0), __ -> new ArrayList<>()).add(pair.get(1));
            adjList.computeIfAbsent(pair.get(1), __ -> new ArrayList<>()).add(pair.get(0));
        }

        return adjList;
    }
}
