package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/evaluate-division
 * Difficulty: Medium
 * Time complexity: O(n * queries)
 * Space complexity: O(n)
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> adjList = buildAdjList(equations, values);

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            results[i] = calculate(query.get(0), query.get(1), adjList);
        }

        return results;
    }

    private double calculate(String start, String target, Map<String, List<Edge>> adjList) {
        if (!adjList.containsKey(start) || !adjList.containsKey(target)) return -1.0;
        if (Objects.equals(start, target)) return 1.0;

        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<Edge> planned = new LinkedList<>();
        planned.offer(new Edge(start, 1));

        while (!planned.isEmpty()) {
            Edge current = planned.poll();
            for (Edge next : adjList.getOrDefault(current.node, List.of())) {

                if (visited.add(next.node)) {
                    if (Objects.equals(next.node, target)) return next.weight * current.weight;
                    planned.offer(new Edge(next.node, next.weight * current.weight));
                }
            }
        }


        return -1.0;
    }

    private Map<String, List<Edge>> buildAdjList(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            double weight = values[i];

            adjList.computeIfAbsent(edge.get(0), __ -> new ArrayList<>()).add(new Edge(edge.get(1), weight));
            adjList.computeIfAbsent(edge.get(1), __ -> new ArrayList<>()).add(new Edge(edge.get(0), 1 / weight));
        }

        return adjList;
    }

    private record Edge(String node, double weight) {
    }
}
