package array;

/**
 * Description: https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        return pointer;
    }
}
