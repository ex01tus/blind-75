package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts
 * Difficulty: Easy
 */
public class MakeArrayZeroBySubtractingEqualAmounts {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int minimumOperationsViaSet(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (num != 0) unique.add(num);
        }

        return unique.size();
    }

    /**
     * Time complexity: O(nlog n + n)
     * Space complexity: O(log n)
     */
    public int minimumOperationsViaSorting(int[] nums) {
        Arrays.sort(nums);

        int current = 0;
        int operations = 0;
        int subtract = 0;
        while (current < nums.length) {
            int num = nums[current] - subtract;
            if (num == 0) {
                current++;
                continue;
            }

            subtract += num;
            operations++;

            current++;
        }

        return operations;
    }
}
