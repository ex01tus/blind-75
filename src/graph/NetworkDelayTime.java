package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/network-delay-time
 * Difficulty: Medium
 */
public class NetworkDelayTime {

    /**
     * Time complexity: O(edges * n)
     * Space complexity: O(n)
     */
    public int networkDelayTimeViaBellmanFordAlgo(int[][] times, int n, int k) {
        int[] delays = new int[n];
        Arrays.fill(delays, Integer.MAX_VALUE);
        delays[k - 1] = 0;

        // shortest path contains at most `n - 1` edges, because it can not have a cycle
        for (int i = 0; i < n - 1; i++) {
            int[] tmp = Arrays.copyOf(delays, delays.length);
            for (int[] edge : times) {
                int from = edge[0] - 1;
                int to = edge[1] - 1;
                int time = edge[2];

                if (delays[from] != Integer.MAX_VALUE) {
                    tmp[to] = Math.min(tmp[to], delays[from] + time);
                }
            }

            delays = tmp;
        }

        int longestDelay = -1;
        for (int delay : delays) {
            if (delay == Integer.MAX_VALUE) return -1; // at least one node is unreachable
            longestDelay = Math.max(longestDelay, delay);
        }

        return longestDelay;
    }

    /**
     * Time complexity: O(edges * log n)
     * Space complexity: O(n)
     */
    public int networkDelayTimeViaDijkstraAlgo(int[][] times, int n, int k) {
        Map<Integer, List<Tuple>> adjList = buildAdjList(times);

        int[] delays = new int[n];
        Arrays.fill(delays, Integer.MAX_VALUE);

        Queue<Tuple> planned = new PriorityQueue<>(Comparator.comparingInt(a -> a.delay));
        planned.offer(new Tuple(k - 1, 0));

        while (!planned.isEmpty()) {
            Tuple current = planned.poll();
            int currentNode = current.node;
            int currentDelay = current.delay;

            if (delays[currentNode] != Integer.MAX_VALUE) continue; // already visited -> already found shortest path
            delays[currentNode] = currentDelay;

            for (Tuple next : adjList.getOrDefault(currentNode, List.of())) {
                if (delays[next.node] != Integer.MAX_VALUE) continue; // already visited -> optional optimization
                planned.offer(new Tuple(next.node, currentDelay + next.delay));
            }
        }

        int longestDelay = -1;
        for (int delay : delays) {
            if (delay == Integer.MAX_VALUE) return -1;
            longestDelay = Math.max(longestDelay, delay);
        }

        return longestDelay;
    }

    private Map<Integer, List<Tuple>> buildAdjList(int[][] edges) {
        Map<Integer, List<Tuple>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0] - 1, __ -> new ArrayList<>()).add(new Tuple(edge[1] - 1, edge[2]));
        }

        return adjList;
    }

    private record Tuple(int node, int delay) {
    }
}
