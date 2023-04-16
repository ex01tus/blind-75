package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/flower-planting-with-no-adjacent
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> adjList = buildAdjList(paths);

        int[] colors = new int[n];
        for (int garden = 0; garden < n; garden++) {
            if (colors[garden] == 0) {
                bfs(adjList, colors, garden);
            }
        }

        return colors;
    }

    private void bfs(Map<Integer, List<Integer>> adjList, int[] colors, int start) {
        Queue<Integer> planned = new LinkedList<>();
        planned.offer(start);
        colors[start] = 1;

        while (!planned.isEmpty()) {
            int current = planned.poll();

            for (int neighbor : adjList.getOrDefault(current, List.of())) {
                if (colors[neighbor] == 0) {
                    // colors are 1-indexed: (colors[current] - 1 + 1) % 4 + 1 = colors[current] % 4 + 1
                    colors[neighbor] = colors[current] % 4 + 1;
                    planned.offer(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    colors[neighbor] = colors[current] % 4 + 1;
                }
            }
        }
    }

    public int[] gardenNoAdjViaGreedyAlgo(int n, int[][] paths) {
        Map<Integer, List<Integer>> adjList = buildAdjList(paths);

        int[] colors = new int[n];
        for (int garden = 0; garden < n; garden++) {
            Set<Integer> usedColors = new HashSet<>();
            for (int neighbor : adjList.getOrDefault(garden, List.of())) {
                usedColors.add(colors[neighbor]);
            }

            for (int color = 1; color <= 4; color++) {
                if (!usedColors.contains(color)) {
                    colors[garden] = color;
                    break;
                }
            }
        }

        return colors;
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] paths) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] path : paths) {
            adjList.computeIfAbsent(path[0] - 1, __ -> new ArrayList<>()).add(path[1] - 1);
            adjList.computeIfAbsent(path[1] - 1, __ -> new ArrayList<>()).add(path[0] - 1);
        }

        return adjList;
    }
}
