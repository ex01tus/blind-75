package string;

/**
 * Description: https://leetcode.com/problems/valid-palindrome
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
