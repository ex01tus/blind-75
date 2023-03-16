package graph;

/**
 * Description: https://leetcode.com/problems/redundant-connection
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RedundantConnection {

    public int[] findRedundantConnectionViaUnionFind(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] ranks = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for (int[] edge : edges) {
            if (!uniteByRank(parents, ranks, edge[0], edge[1])) {
                return edge;
            }
        }

        throw new RuntimeException();
    }

    private boolean uniteByRank(int[] parents, int[] ranks, int node1, int node2) {
        int parent1 = findParent(parents, node1);
        int parent2 = findParent(parents, node2);

        if (parent1 == parent2) return false; // connection between node1 and node2 already exists

        // connect smaller subgraph to a bigger one
        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }

        return true;
    }

    private int findParent(int[] parents, int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]]; // optional path compression
            node = parents[node];
        }

        return node;
    }
}
