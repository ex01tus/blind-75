package graph;

/**
 * Description: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStonesViaUnionFind(int[][] stones) {
        int[] parents = new int[stones.length];
        int[] ranks = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int components = stones.length;
        for (int stone1 = 0; stone1 < stones.length; stone1++) {
            for (int stone2 = stone1 + 1; stone2 < stones.length; stone2++) {
                if (areSharingSameRowOrCol(stones[stone1], stones[stone2])) {
                    components -= uniteAndCount(parents, ranks, stone1, stone2);
                }
            }
        }

        return stones.length - components;
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

    private boolean areSharingSameRowOrCol(int[] stone1, int[] stone2) {
        return stone1[0] == stone2[0] || stone1[1] == stone2[1];
    }
}
