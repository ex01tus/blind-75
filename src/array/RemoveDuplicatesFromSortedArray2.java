package array;

/**
 * Description: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int pointer = 1;
        int duplicateCounter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicateCounter++;
            } else {
                duplicateCounter = 1;
            }

            if (duplicateCounter <= 2) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        return pointer;
    }
}
