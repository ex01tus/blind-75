package graph;

/**
 * Description: https://leetcode.com/problems/number-of-provinces
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NumberOfProvinces {

    public int findCircleNumViaUnionFind(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parents = new int[cities];
        int[] ranks = new int[cities];
        for (int i = 0; i < cities; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int provinces = cities;
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    provinces -= uniteAndCount(parents, ranks, i, j);
                }
            }
        }

        return provinces;
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
