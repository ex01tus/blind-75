package array;

/**
 * Description: https://leetcode.com/problems/sign-of-the-product-of-an-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SignOfTheProductOfArray {

    public int arraySign(int[] nums) {
        int negatives = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) negatives++;
        }

        return negatives % 2 == 0 ? 1 : -1;
    }
}
