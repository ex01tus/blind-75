package array;

/**
 * Description: https://leetcode.com/problems/rearrange-array-elements-by-sign
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        int[] rearranged = new int[nums.length];
        int positivePointer = 0;
        int negativePointer = 1;

        for (int num : nums) {
            if (num > 0) {
                rearranged[positivePointer] = num;
                positivePointer += 2;
            } else {
                rearranged[negativePointer] = num;
                negativePointer += 2;
            }
        }

        return rearranged;
    }
}
