package graph;

/**
 * Description: https://leetcode.com/problems/graph-valid-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class GraphValidTree {

    public boolean validTreeViaUnionFind(int n, int[][] edges) {
        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int components = n;
        for (int[] edge : edges) {
            int union = uniteAndCount(parents, ranks, edge[0], edge[1]);
            if (union == 0) return false; // union wasn't performed -> we have found a cycle
            components -= union;
        }

        return components == 1; // check if the graph is fully connected
    }

    private int uniteAndCount(int[] parents, int[] ranks, int node1, int node2) {
        int parent1 = findParent(parents, node1);
        int parent2 = findParent(parents, node2);

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

    private int findParent(int[] parents, int node) {
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }
}
