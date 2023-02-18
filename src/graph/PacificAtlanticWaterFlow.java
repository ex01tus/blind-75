package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/pacific-atlantic-water-flow
 * Difficulty: Medium
 */
public class PacificAtlanticWaterFlow {

    private int[][] directions;

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     */
    public List<List<Integer>> pacificAtlanticOptimalApproach(int[][] heights) {
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];

        // start flow from left and right borders
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, pacific, new int[]{i, 0});
            dfs(heights, atlantic, new int[]{i, heights.length - 1});
        }

        // start flow from top and bottom borders
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, pacific, new int[]{0, i});
            dfs(heights, atlantic, new int[]{heights[0].length - 1, i});
        }

        // if cell was visited by both flows -> add to the result
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] != 0 && atlantic[i][j] != 0) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int[][] visited, int[] start) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            if (visited[current[0]][current[1]] == 0) {
                stack.push(current);
                visited[current[0]][current[1]] = 1;

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length
                            && visited[x][y] == 0
                            // we're going backwards -> next height should be greater or equal than current
                            && heights[x][y] >= heights[current[0]][current[1]]) {
                        stack.push(new int[]{x, y});
                    }
                }
            } else if (visited[current[0]][current[1]] == 1) {
                visited[current[0]][current[1]] = 2;
            }
        }
    }

    /**
     * Time complexity: O(m^2 * n^2)
     * Space complexity: O(m * n)
     */
    public List<List<Integer>> pacificAtlanticNaiveApproach(int[][] heights) {
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (canFlowBothWays(heights, new int[]{i, j})) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private boolean canFlowBothWays(int[][] heights, int[] start) {
        int[][] visited = new int[heights.length][heights[0].length];
        boolean hasPacificPath = false;
        boolean hasAtlanticPath = false;

        Deque<int[]> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            if (visited[current[0]][current[1]] == 0) {
                visited[current[0]][current[1]] = 1;
                stack.push(current);

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x < 0 || y < 0) {
                        hasPacificPath = true;
                    } else if (x >= heights.length || y >= heights[0].length) {
                        hasAtlanticPath = true;
                    } else if (visited[x][y] == 0 && heights[x][y] <= heights[current[0]][current[1]]) {
                        stack.push(new int[]{x, y});
                    }

                    if (hasPacificPath && hasAtlanticPath) return true;
                }
            } else if (visited[current[0]][current[1]] == 1) {
                visited[current[0]][current[1]] = 2;
            }
        }

        return false;
    }
}
