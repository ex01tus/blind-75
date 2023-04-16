package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Neighbor>> adjList = buildAdjList(connections);

        int[] visited = new int[n];
        visited[0] = 1;

        Deque<Integer> planned = new LinkedList<>();
        planned.offer(0);

        int reverse = 0;
        while (!planned.isEmpty()) {
            int current = planned.poll();

            for (Neighbor neighbor : adjList.getOrDefault(current, List.of())) {
                if (visited[neighbor.idx] == 0) {
                    if (!neighbor.isReversed) reverse++;
                    planned.offer(neighbor.idx);
                    visited[neighbor.idx] = 1;
                }
            }
        }

        return reverse;
    }

    private Map<Integer, List<Neighbor>> buildAdjList(int[][] connections) {
        Map<Integer, List<Neighbor>> adjList = new HashMap<>();
        for (int[] path : connections) {
            adjList.computeIfAbsent(path[0], __ -> new ArrayList<>()).add(new Neighbor(path[1], false));
            adjList.computeIfAbsent(path[1], __ -> new ArrayList<>()).add(new Neighbor(path[0], true));
        }

        return adjList;
    }

    private record Neighbor(int idx, boolean isReversed) {
    }
}
