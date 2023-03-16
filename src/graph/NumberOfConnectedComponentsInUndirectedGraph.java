package graph;

/**
 * Description: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NumberOfConnectedComponentsInUndirectedGraph {

    public int countComponentsViaUnionFind(int n, int[][] edges) {
        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int components = n;
        for (int[] edge : edges) {
            components -= uniteAndCount(parents, ranks, edge[0], edge[1]);
        }

        return components;
    }

    private int uniteAndCount(int[] parents, int[] ranks, int node1, int node2) {
        int parent1 = findParent(node1, parents);
        int parent2 = findParent(node2, parents);

        if (parent1 == parent2) return 0; // no union needed -> number of components remains the same

        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }

        return 1; // each successful union reduces the number of components by one
    }

    private int findParent(int node, int[] parents) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }
}
