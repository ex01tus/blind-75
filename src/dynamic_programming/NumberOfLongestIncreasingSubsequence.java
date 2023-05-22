package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/number-of-longest-increasing-subsequence
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        int longest = 1;

        for (int left = nums.length - 1; left >= 0; left--) {
            for (int right = left; right < nums.length; right++) {
                if (left == right) {
                    length[left] = 1;
                    count[left] = 1;
                    continue;
                }

                if (nums[left] < nums[right]) {
                    // increasing subsequence was found
                    if (length[left] < length[right] + 1) {
                        // new longest
                        count[left] = count[right];
                        length[left] = length[right] + 1;
                    } else if (length[left] == length[right] + 1) {
                        // yet another longest
                        count[left] += count[right];
                    }
                }
            }

            longest = Math.max(longest, length[left]);
        }

        int result = 0;
        for (int i = 0; i < length.length; i++) {
            if (length[i] == longest) result += count[i];
        }

        return result;
    }
}
