package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/all-paths-from-source-to-target
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);

        dfs(graph, 0, currentPath, result);

        return result;
    }

    private void dfs(int[][] graph, int start, List<Integer> currentPath, List<List<Integer>> result) {
        if (start == graph.length - 1) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < graph[start].length; i++) {
            currentPath.add(graph[start][i]);
            dfs(graph, graph[start][i], currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
