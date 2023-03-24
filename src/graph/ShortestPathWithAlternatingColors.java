package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/shortest-path-with-alternating-colors
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ShortestPathWithAlternatingColors {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int UNKNOWN = -1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Node>> adjList = toAdjList(redEdges, blueEdges);
        return findShortestPaths(adjList, n);
    }

    private int[] findShortestPaths(Map<Integer, List<Node>> adjList, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        distances[0] = 0;

        int[][] visited = new int[n][2]; // each node can be visited twice: via red edge and via blue edge
        visited[0][RED] = 1;
        visited[0][BLUE] = 1;

        Queue<Node> planned = new LinkedList<>();
        planned.offer(new Node(0, UNKNOWN)); // can start our path with both red and blue edges

        int distance = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();

                for (Node neighbor : adjList.getOrDefault(current.idx, List.of())) {
                    if (visited[neighbor.idx][neighbor.edgeColor] == 0
                            && neighbor.edgeColor != current.edgeColor) { // alternate edge colors
                        if (distances[neighbor.idx] == -1) { // only update distance once
                            distances[neighbor.idx] = distance;
                        }

                        visited[neighbor.idx][neighbor.edgeColor] = 1;
                        planned.offer(neighbor);
                    }
                }
            }
        }

        return distances;
    }

    private Map<Integer, List<Node>> toAdjList(int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        for (int[] edge : redEdges) {
            adjList.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(new Node(edge[1], RED));
        }

        for (int[] edge : blueEdges) {
            adjList.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(new Node(edge[1], BLUE));
        }

        return adjList;
    }

    private static class Node {

        private final int idx;
        private final int edgeColor;

        public Node(int idx, int edgeColor) {
            this.idx = idx;
            this.edgeColor = edgeColor;
        }
    }
}
