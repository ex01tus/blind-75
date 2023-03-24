package graph;

/**
 * Description: https://leetcode.com/problems/number-of-operations-to-make-network-connected
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnectedViaUnionFind(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // not enough cables

        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int components = n;
        for (int[] connection : connections) {
            components -= uniteAndCount(parents, ranks, connection[0], connection[1]);
        }

        return components - 1;
    }

    private int uniteAndCount(int[] parents, int[] ranks, int node1, int node2) {
        int parent1 = findParent(parents, node1);
        int parent2 = findParent(parents, node2);

        if (parent1 == parent2) return 0;

        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }

        return 1;
    }

    private int findParent(int[] parents, int node) {
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }
}
