package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-to-get-all-keys
 * Difficulty: Hard
 * Time complexity: O(2^k * m * n)
 * Space complexity: O(2^k * m * n)
 */
public class ShortestPathToGetAllKeys {

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestPathAllKeys(String[] lines) {
        char[][] grid = toGrid(lines);

        int keysNumber = 0;
        int x = -1;
        int y = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isKey(grid[i][j])) {
                    keysNumber++;
                } else if (isStart(grid[i][j])) {
                    x = i;
                    y = j;
                }
            }
        }

        return findShortestPath(grid, keysNumber, x, y);
    }

    private int findShortestPath(char[][] grid, int keysNumber, int x, int y) {
        // 1 << 5 - 1 = 100000 - 1 = 11111
        int allKeysFoundMask = (1 << keysNumber) - 1;

        // we may visit the same node multiple times with a different set of keys
        int[][][] visited = new int[grid.length][grid[0].length][allKeysFoundMask];
        visited[x][y][0] = 1;

        Queue<Node> planned = new LinkedList<>();
        planned.offer(new Node(x, y, 0));

        int distance = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();

                for (int[] dir : directions) {
                    int x1 = current.x + dir[0];
                    int y1 = current.y + dir[1];

                    if (!isValid(x1, y1, grid) || isWall(grid[x1][y1])) continue;

                    char next = grid[x1][y1];
                    int mask = current.mask;

                    // we have no key for this lock, e.g:
                    // 1. mask = 1001 -> we have 'a' and 'd' keys
                    // 2. lock = 'B'  -> 'B' - 'A' = 1
                    // 3. mask >> 1 = 1001 >> 1 = 100
                    // 4. 100 & 1 == 0 -> locked
                    if (isLock(next) && (mask >> (next - 'A') & 1) == 0) continue;

                    // found a key
                    if (isKey(next)) {
                        mask = mask | (1 << (next - 'a'));
                        if (mask == allKeysFoundMask) return distance;
                    }

                    if (visited[x1][y1][mask] == 0) {
                        planned.offer(new Node(x1, y1, mask));
                        visited[x1][y1][mask] = 1;
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y, char[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    private boolean isKey(char c) {
        return Character.isLowerCase(c);
    }

    private boolean isLock(char c) {
        return Character.isUpperCase(c);
    }

    private boolean isStart(char c) {
        return c == '@';
    }

    private boolean isWall(char c) {
        return c == '#';
    }

    private char[][] toGrid(String[] lines) {
        char[][] grid = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }

        return grid;
    }

    private record Node(int x, int y, int mask) {
    }
}
