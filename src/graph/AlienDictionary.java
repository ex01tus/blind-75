package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/alien-dictionary
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AlienDictionary {

    public String alienOrderViaTopologicalSort(String[] words) {
        Map<Character, List<Character>> adjList = buildAdjList(words);
        if (adjList.isEmpty()) return "";

        // topologically sorted (DESC) graph nodes
        StringBuilder sortedChars = new StringBuilder();
        int[] visited = new int[26];
        for (char c : adjList.keySet()) {
            if (visited[c - 'a'] == 0 && hasCycle(c, adjList, visited, sortedChars)) {
                // cycle found -> no valid answer
                return "";
            }
        }

        return sortedChars.reverse().toString();
    }

    private boolean hasCycle(
            char start,
            Map<Character, List<Character>> adjList,
            int[] visited,
            StringBuilder sortedChars) {
        Deque<Character> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            char current = stack.pop();
            if (visited[current - 'a'] == 0) {
                visited[current - 'a'] = 1;
                stack.push(current);

                for (char neighbor : adjList.getOrDefault(current, List.of())) {
                    if (visited[neighbor - 'a'] == 1) return true;
                    if (visited[neighbor - 'a'] == 0) {
                        stack.push(neighbor);
                    }
                }
            } else if (visited[current - 'a'] == 1) {
                visited[current - 'a'] = 2;
                sortedChars.append(current);
            }
        }

        return false;
    }

    private Map<Character, List<Character>> buildAdjList(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();

        // find all nodes
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // find all edges
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            // prefix goes after longer word -> invalid sequence
            if (word2.length() < word1.length() && word1.startsWith(word2)) return Map.of();

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                // find first non match
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        return adjList;
    }
}
