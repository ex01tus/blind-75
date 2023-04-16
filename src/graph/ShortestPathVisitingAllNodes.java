package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-visiting-all-nodes
 * Difficulty: Hard
 * Time complexity: O(2^n * n * n)
 * Space complexity: O(2^n * n)
 */
public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) return 0;

        int allVisitedMask = (1 << graph.length) - 1; // for 5 nodes: 1 << 5 - 1 = 100000 - 1 = 11111
        int[][] visited = new int[graph.length][allVisitedMask];

        Queue<Node> planned = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            int nodeVisitedMask = 1 << i; // 1 << 0 = 1; 1 << 1 = 10; 1 << 2 = 100; 1 << 3 = 1000; 1 << 4 = 10000
            planned.offer(new Node(i, nodeVisitedMask));
            visited[i][nodeVisitedMask] = 1;
        }

        int pathLength = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            pathLength++;

            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();

                for (int neighbor : graph[current.idx]) {
                    int nextMask = current.mask | (1 << neighbor); // 1 | 10 = 11 -> '0' and '1' has been visited
                    if (nextMask == allVisitedMask) return pathLength;

                    if (visited[neighbor][nextMask] == 0) {
                        visited[neighbor][nextMask] = 1;
                        planned.offer(new Node(neighbor, nextMask));
                    }
                }
            }
        }

        return -1;
    }

    private record Node(int idx, int mask) {
    }
}
