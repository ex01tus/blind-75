package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/minimum-height-trees
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        Map<Integer, Set<Integer>> adjList = buildAdjList(edges);
        return findMiddleNodes(adjList);
    }

    private Map<Integer, Set<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], __ -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], __ -> new HashSet<>()).add(edge[0]);
        }

        return adjList;
    }

    private List<Integer> findMiddleNodes(Map<Integer, Set<Integer>> adjList) {
        int nodesLeft = adjList.size();
        List<Integer> leaves = findLeaves(adjList);

        while (nodesLeft > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                Set<Integer> neighbors = adjList.remove(leaf);
                for (int neighbor : neighbors) {
                    Set<Integer> neighborConnections = adjList.get(neighbor);

                    neighborConnections.remove(leaf);
                    if (neighborConnections.size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }

            nodesLeft -= leaves.size();
            leaves = newLeaves;
        }

        return leaves;
    }

    private List<Integer> findLeaves(Map<Integer, Set<Integer>> adjList) {
        List<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : adjList.entrySet()) {
            if (entry.getValue().size() == 1) {
                leaves.add(entry.getKey());
            }
        }

        return leaves;
    }
}
