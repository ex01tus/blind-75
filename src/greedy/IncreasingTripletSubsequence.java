package greedy;

/**
 * Description: https://leetcode.com/problems/increasing-triplet-subsequence
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        // small < mid < large
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                // large was found
                return true;
            }
        }

        return false;
    }
}
