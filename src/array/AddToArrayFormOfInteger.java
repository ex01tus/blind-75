package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/add-to-array-form-of-integer
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = k;

        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }

        while (carry != 0) {
            result.add(carry % 10);
            carry = carry / 10;
        }

        Collections.reverse(result);
        return result;
    }
}
