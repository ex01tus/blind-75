package graph;

/**
 * Description: https://leetcode.com/problems/maximal-network-rank
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] ranks = new int[n];
        int[][] adjMatrix = new int[n][n];
        for (int[] road : roads) {
            ranks[road[0]]++;
            ranks[road[1]]++;
            adjMatrix[road[0]][road[1]] = 1;
            adjMatrix[road[1]][road[0]] = 1;
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // road between 'i' and 'j' is only counted once -> subtract 1 if connection exists
                maxRank = Math.max(maxRank, ranks[i] + ranks[j] - adjMatrix[i][j]);
            }
        }

        return maxRank;
    }
}
