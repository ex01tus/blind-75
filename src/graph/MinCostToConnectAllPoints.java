package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/min-cost-to-connect-all-points
 * Difficulty: Medium
 * Time complexity: O(n^2 * log n^2)
 * Space complexity: O(n^2)
 */
public class MinCostToConnectAllPoints {

    public int minCostConnectPointsViaUnionFind(int[][] points) {
        int[] parents = new int[points.length];
        int[] ranks = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        List<Edge> edges = buildAllPossibleEdgesSortedByDistance(points);
        int usedEdges = 0;
        int cost = 0;
        for (Edge edge : edges) {
            if (unite(parents, ranks, edge.point1, edge.point2)) {
                cost += edge.distance;
                usedEdges++;
            }

            // all points are now connected
            if (usedEdges == points.length - 1) break;
        }

        return cost;
    }

    private List<Edge> buildAllPossibleEdgesSortedByDistance(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.distance));
        return edges;
    }

    private boolean unite(int[] parents, int[] ranks, int node1, int node2) {
        int parent1 = findParent(parents, node1);
        int parent2 = findParent(parents, node2);

        if (parent1 == parent2) return false;

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
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    private record Edge(int point1, int point2, int distance) {}
}
