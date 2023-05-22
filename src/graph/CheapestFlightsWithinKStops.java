package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/cheapest-flights-within-k-stops
 * Difficulty: Medium
 */
public class CheapestFlightsWithinKStops {

    /**
     * Time complexity: O(edges * k)
     * Space complexity: O(edges)
     */
    public int findCheapestPriceViaBellmanFordAlgo(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int stop = 0; stop <= k; stop++) {
            int[] tmp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // edge is reachable from the current BFS level
                if (prices[from] != Integer.MAX_VALUE) {
                    tmp[to] = Math.min(tmp[to], prices[from] + price);
                }
            }

            prices = tmp;
        }

        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }

    /**
     * Time complexity: O(k * f * log kf)
     * Space complexity: O(k * f)
     */
    public int findCheapestPriceViaDijkstraAlgo(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Flight>> adjList = buildAdjList(flights);

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<Flight> planned = new PriorityQueue<>(Comparator.comparingInt(a -> a.price));
        planned.offer(new Flight(src, 0, 0));

        while (!planned.isEmpty()) {
            Flight current = planned.poll();
            int currentCity = current.city;
            int currentPrice = current.price;
            int currentStops = current.stops;

            if (currentStops > stops[currentCity] || currentStops > k + 1) continue;
            if (currentCity == dst) return currentPrice;

            stops[currentCity] = currentStops;
            for (Flight next : adjList.getOrDefault(currentCity, List.of())) {
                planned.offer(new Flight(next.city, current.price + next.price, current.stops + 1));
            }
        }

        return -1;
    }

    private Map<Integer, List<Flight>> buildAdjList(int[][] flights) {
        Map<Integer, List<Flight>> adjList = new HashMap<>();
        for (int[] flight : flights) {
            adjList.computeIfAbsent(flight[0], __ -> new ArrayList<>()).add(new Flight(flight[1], flight[2], 0));
        }

        return adjList;
    }

    private record Flight(int city, int price, int stops) {
    }
}
