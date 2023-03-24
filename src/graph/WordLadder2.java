package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/word-ladder-ii
 * Difficulty: Hard
 * Time complexity: O(n * w^2)
 * Space complexity: O(n * w^2)
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return List.of();

        wordList.add(beginWord);
        Map<String, List<String>> adjList = buildAdjList(wordList);

        return find(beginWord, endWord, adjList);
    }

    private List<List<String>> find(
            String start,
            String target,
            Map<String, List<String>> adjList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        visited.add(start);

        // store full paths in queue
        Queue<List<String>> planned = new LinkedList<>();
        planned.offer(new ArrayList<>(List.of(start)));

        while (!planned.isEmpty()) {
            int levelSize = planned.size();

            // we're allowed to visit the same nodes within the same level
            Set<String> localVisited = new HashSet<>();
            for (int i = 0; i < levelSize; i++) {
                List<String> currentPath = planned.poll();
                String currentWord = currentPath.get(currentPath.size() - 1);

                Set<String> neighbors = findNeighbors(adjList, currentWord);
                for (String neighbor : neighbors) {
                    if (visited.contains(neighbor)) continue;

                    List<String> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);
                    localVisited.add(neighbor);
                    if (neighbor.equals(target)) {
                        result.add(newPath);
                    } else {
                        planned.offer(newPath);
                    }
                }
            }

            visited.addAll(localVisited);
        }

        return result;
    }

    private Map<String, List<String>> buildAdjList(List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();
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
