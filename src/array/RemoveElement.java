package array;

/**
 * Description: https://leetcode.com/problems/remove-element
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int num : nums) {
            if (num != val) {
                nums[pointer++] = num;
            }
        }

        return pointer;
    }
}
