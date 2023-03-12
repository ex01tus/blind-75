package math;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/plus-one
 * Difficulty: Easy
 */
public class PlusOne {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int[] plusOneOptimalApproach(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result; // 100<...>0
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[] plusOneNaiveApproach(int[] digits) {
        List<Integer> result = new LinkedList<>();

        int carry = 1; // plus one
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            result.add(0, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            result.add(0, carry);
        }

        return result.stream().mapToInt(v -> v).toArray();
    }
}
