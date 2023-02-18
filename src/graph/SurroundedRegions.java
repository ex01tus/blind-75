package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/surrounded-regions
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class SurroundedRegions {

    private int[][] directions;
    private int[][] visited;

    public void solve(char[][] board) {
        visited = new int[board.length][board[0].length];
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int component = 2;
        Set<Integer> surroundedComponents = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    if (isSurrounded(board, new int[]{i, j}, component)) {
                        surroundedComponents.add(component);
                    }
                }

                component++;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (surroundedComponents.contains(visited[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, int[] start, int component) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(start);

        boolean isSurrounded = true;
        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            if (visited[current[0]][current[1]] == 0) {
                visited[current[0]][current[1]] = 1;
                stack.push(current);

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                        isSurrounded = false;
                        continue;
                    }

                    if (board[x][y] == 'O' && visited[x][y] == 0) {
                        stack.push(new int[]{x, y});
                    }
                }
            } else if (visited[current[0]][current[1]] == 1) {
                visited[current[0]][current[1]] = component;
            }
        }

        return isSurrounded;
    }
}
