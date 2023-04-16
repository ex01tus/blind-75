package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/minimum-genetic-mutation
 * Difficulty: Medium
 * Time complexity: O(4^n * n^2 + b)
 * Space complexity: O(4^n + b)
 */
public class MinimumGeneticMutation {

    private final Set<Character> alphabet = Set.of('A', 'C', 'G', 'T');

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;

        Set<String> valid = new HashSet<>(Arrays.asList(bank));
        if (!valid.contains(endGene)) return -1;

        // BFS with 4^n nodes
        return findShortestPath(startGene, endGene, valid);
    }

    private int findShortestPath(String start, String end, Set<String> valid) {
        Queue<String> planned = new LinkedList<>();
        planned.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        int steps = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            steps++;

            for (int i = 0; i < levelSize; i++) {
                String current = planned.poll();
                for (String neighbor : findNeighbors(current)) {
                    if (valid.contains(neighbor) && visited.add(neighbor)) {
                        if (neighbor.equals(end)) return steps;
                        planned.offer(neighbor);
                    }
                }
            }
        }

        return -1;
    }

    // takes O(n * 3 * n) time – n chars, 3 possible mutations, and we call substring(n)
    private List<String> findNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < current.length(); i++) {
            char c = current.charAt(i);
            for (char mutation : alphabet) {
                if (c == mutation) continue;
                String next = current.substring(0, i) + mutation + current.substring(i + 1);
                neighbors.add(next);
            }
        }

        return neighbors;
    }
}
