package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/bus-routes
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBusesMap = buildStopToBusesMap(routes);
        return countMinBusNumber(stopToBusesMap, routes, source, target);
    }

    private int countMinBusNumber(
            Map<Integer, List<Integer>> stopToBusesMap,
            int[][] routes,
            int source,
            int target) {
        int[] usedBuses = new int[routes.length];
        Queue<Integer> planned = new LinkedList<>();
        planned.offer(source);

        int buses = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            buses++;

            for (int i = 0; i < levelSize; i++) {
                int currentStop = planned.poll();
                for (int bus : stopToBusesMap.getOrDefault(currentStop, List.of())) {
                    if (usedBuses[bus] != 0) continue;

                    usedBuses[bus] = 1;
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return buses;
                        planned.offer(nextStop);
                    }
                }
            }
        }

        return -1;
    }

    private Map<Integer, List<Integer>> buildStopToBusesMap(int[][] routes) {
        Map<Integer, List<Integer>> stopToBusesMap = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            int[] stops = routes[bus];
            for (int stop : stops) {
                stopToBusesMap.computeIfAbsent(stop, __ -> new ArrayList<>()).add(bus);
            }
        }

        return stopToBusesMap;
    }
}
