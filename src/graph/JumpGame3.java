package graph;

/**
 * Description: https://leetcode.com/problems/jump-game-iii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class JumpGame3 {

    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new int[arr.length]);
    }

    private boolean canReach(int[] arr, int start, int[] visited) {
        if (start < 0 || start >= arr.length || visited[start] == 1) return false;
        if (arr[start] == 0) return true;

        visited[start] = 1;
        boolean jumpRight = canReach(arr, start + arr[start], visited);
        boolean jumpLeft = canReach(arr, start - arr[start], visited);

        return jumpRight || jumpLeft;
    }
}
