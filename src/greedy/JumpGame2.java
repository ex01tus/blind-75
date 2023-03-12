package greedy;

/**
 * Description: https://leetcode.com/problems/jump-game-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int farthestReachablePosition = 0;
        int prevFarthestJumpEnd = 0;
        int jumps = 0;

        // [2] (3 6) 1 4 5: (3 6) are reachable from [2] within one jump
        // 2 [3] (6 1 4) 5: (6 1 4) are reachable from [3] within one jump
        // 2 3 [6] (1 4 5): (1 4 5) are reachable from [6] within one jump
        // Optimal solution: 2 -> (3 6) -> (1 4 5), three jumps
        for (int currentPosition = 0; currentPosition < nums.length - 1; currentPosition++) {
            farthestReachablePosition = Math.max(farthestReachablePosition, currentPosition + nums[currentPosition]);

            // have to jump
            if (prevFarthestJumpEnd == currentPosition) {
                jumps++;
                prevFarthestJumpEnd = farthestReachablePosition;
            }
        }

        return jumps;
    }
}
