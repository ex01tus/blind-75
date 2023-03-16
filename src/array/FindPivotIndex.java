package array;

/**
 * Description: https://leetcode.com/problems/find-pivot-index
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
