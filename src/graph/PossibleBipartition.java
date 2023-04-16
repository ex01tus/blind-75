package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/possible-bipartition
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class PossibleBipartition {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int UNDEFINED = -1;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adjList = buildAdjList(dislikes);
        int[] colors = new int[n + 1];
        Arrays.fill(colors, UNDEFINED);

        for (int i = 1; i <= n; i++) {
            if (colors[i] == UNDEFINED && !isBipartite(i, adjList, colors)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBipartite(int start, Map<Integer, List<Integer>> adjList, int[] colors) {
        Queue<Integer> planned = new LinkedList<>();
        planned.offer(start);
        colors[start] = RED;

        while (!planned.isEmpty()) {
            int current = planned.poll();

            for (int neighbor : adjList.getOrDefault(current, List.of())) {
                if (colors[neighbor] == UNDEFINED) {
                    // color nodes red-blue-red-blue-...
                    colors[neighbor] = (colors[current] + 1) % 2;
                    planned.offer(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    // if colors of neighbors match – graph is not bipartile
                    return false;
                }
            }
        }

        return true;
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
        }

        return adjList;
    }
}
