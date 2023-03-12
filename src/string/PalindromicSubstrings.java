package string;

/**
 * Description: https://leetcode.com/problems/palindromic-substrings
 * Difficulty: Medium
 */
public class PalindromicSubstrings {

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int countSubstringsViaPalindromeExtending(String s) {
        int count = 0;

        for (int center = 0; center < s.length(); center++) {
            count += extendAndCount(s, center, center); // count odd length palindromes: "[a]", "a[c]a", "ac[a]ca", etc.
            count += extendAndCount(s, center - 1, center); // count even length palindromes: "[aa]", "a[bb]a", etc.
        }

        return count;
    }

    private int extendAndCount(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public int countSubstringsViaDP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;
        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (s.charAt(left) != s.charAt(right)) continue;

                int length = right - left + 1;

                // "a", "aa" and "axa" are always palindromes
                // for longer strings we check if the substring "inside" is palindrome
                boolean isPalindrome = length <= 3 || dp[left + 1][right - 1];
                dp[left][right] = isPalindrome;
                count += isPalindrome ? 1 : 0;
            }
        }

        return count;
    }
}
