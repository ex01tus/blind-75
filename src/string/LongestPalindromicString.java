package string;

/**
 * Description: https://leetcode.com/problems/longest-palindromic-substring
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class LongestPalindromicString {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int maxLength = 0;
        int from = 0;
        int to = 0;

        // logic behind the pointers: left must decrease and right must increase for dp[left + 1][right - 1] to work
        for (int right = 0; right < s.length(); right++) { // for (int left = s.length() - 1; left >= 0; left--)
            for (int left = right; left >= 0; left--) {    // for (int right = left; right < s.length(); right++)
                if (s.charAt(left) != s.charAt(right)) continue;

                int currentLength = right - left + 1;

                if (currentLength <= 2 // "a" and "aa" are always palindromes
                        || dp[left + 1][right - 1]) { // if "cdc" was a palindrome, "a + cdc + a" is also a palindrome
                    dp[left][right] = true;

                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        from = left;
                        to = right;
                    }
                }
            }
        }

        return s.substring(from, to + 1);
    }
}
