package array;

/**
 * Description: https://leetcode.com/problems/concatenation-of-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {
        int[] concatenated = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            concatenated[i] = nums[i];
            concatenated[i + nums.length] = nums[i];
        }

        return concatenated;
    }
}
