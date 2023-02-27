package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/word-ladder
 * Difficulty: Hard
 * Time complexity: O(n * w^2)
 * Space complexity: O(n * w^2)
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        wordList.add(beginWord);
        Map<String, List<String>> adjList = buildAdjList(wordList);

        return findShortestDistance(beginWord, endWord, adjList);
    }

    private int findShortestDistance(String start, String target, Map<String, List<String>> adjList) {
        Set<String> visited = new HashSet<>();
        int distance = 1;

        Queue<String> planned = new LinkedList<>();
        planned.offer(start);
        visited.add(start);

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                String current = planned.poll();
                Set<String> neighbors = findNeighbors(adjList, current);
                for (String neighbor : neighbors) {
                    if (visited.add(neighbor)) {
                        if (neighbor.equals(target)) return distance;
                        planned.offer(neighbor);
                    }
                }
            }
        }

        return 0;
    }

    private Map<String, List<String>> buildAdjList(List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();

        // takes O(n * w^2) time
        for (String word : wordList) {
            List<String> patterns = generatePatterns(word);
            for (String pattern : patterns) {
                adjList.computeIfAbsent(pattern, __ -> new ArrayList<>()).add(word);
            }
        }

        return adjList;
    }

    private List<String> generatePatterns(String word) {
        List<String> patterns = new ArrayList<>();

        // takes O(w^2) time, since we are iterating though the word and using substring on each iteration
        // hot -> [*ot, h*t, ho*]
        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
            patterns.add(pattern);
        }

        return patterns;
    }

    private Set<String> findNeighbors(Map<String, List<String>> adjList, String word) {
        Set<String> neighbors = new HashSet<>();
        List<String> patterns = generatePatterns(word);

        for (String pattern : patterns) {
            List<String> found = adjList.getOrDefault(pattern, List.of());
            neighbors.addAll(found);
        }

        return neighbors;
    }
}
