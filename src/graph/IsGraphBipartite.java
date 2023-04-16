package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/is-graph-bipartite
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class IsGraphBipartite {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int UNDEFINED = -1;

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, UNDEFINED);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == UNDEFINED && !isBipartite(i, graph, colors)) {
                return false;
            }
        }

        return true;
    }
    private boolean isBipartite(int start, int[][] graph, int[] colors) {
        Queue<Integer> planned = new LinkedList<>();
        planned.offer(start);
        colors[start] = RED;

        while (!planned.isEmpty()) {
            int current = planned.poll();

            for (int neighbor : graph[current]) {
                if (colors[neighbor] == UNDEFINED) {
                    // color nodes red-blue-red-blue-...
                    colors[neighbor] = (colors[current] + 1) % 2;
                    planned.offer(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    // if colors of neighbors match – graph is not bipartile
                    return false;
                }
            }
        }

        return true;
    }
}
