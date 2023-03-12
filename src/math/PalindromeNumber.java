package math;

/**
 * Description: https://leetcode.com/problems/palindrome-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false; // negative number can't be a palindrome

        int tmp = x;
        int reversedX = 0;
        while (tmp != 0) {
            int digit = tmp % 10;

            // not really necessary, but it seems easier to add this check,
            // than to prove that in case of overflow we will still return false
            if (reversedX > Integer.MAX_VALUE / 10
                    || (reversedX == Integer.MAX_VALUE / 10 && digit  > Integer.MAX_VALUE % 10)) {
                return false;
            }

            reversedX = reversedX * 10 + digit;

            tmp = tmp / 10;
        }

        return x == reversedX;
    }
}
