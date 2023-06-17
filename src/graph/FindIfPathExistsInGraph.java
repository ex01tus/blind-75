package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-if-path-exists-in-graph
 * Difficulty: Easy
 */
public class FindIfPathExistsInGraph {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean validPathViaDFS(int n, int[][] edges, int source, int destination) {
        if (destination == source) return true;

        Map<Integer, List<Integer>> adjList = buildAdjList(edges);
        return isReachable(adjList, new int[n], source, destination);
    }

    private boolean isReachable(Map<Integer, List<Integer>> adjList, int[] visited, int current, int destination) {
        visited[current] = 1;
        for (int next : adjList.getOrDefault(current, List.of())) {
            if (visited[next] == 0) {
                if (next == destination) return true;
                if (isReachable(adjList, visited, next, destination)) return true;
            }
        }

        return false;
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
        }

        return adjList;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean validPathViaUnionFind(int n, int[][] edges, int source, int destination) {
        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for (int[] edge : edges) {
            unite(edge[0], edge[1], parents, ranks);
        }

        return findParent(source, parents) == findParent(destination, parents);
    }

    private void unite(int node1, int node2, int[] parents, int[] ranks) {
        int parent1 = findParent(node1, parents);
        int parent2 = findParent(node2, parents);

        if (parent1 == parent2) return;

        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
    }

    private int findParent(int node, int[] parents) {
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }
}
