package string;

/**
 * Description: https://leetcode.com/problems/longest-palindromic-substring
 * Difficulty: Medium
 */
public class LongestPalindromicString {

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public String longestPalindromeViaPalindromeExtending(String s) {
        int maxLength = 0;
        int from = 0;
        int to = 0;

        for (int center = 0; center < s.length(); center++) {
            int oddPalindromeLength = extendAndFindLength(s, center, center);
            int evenPalindromeLength = extendAndFindLength(s, center - 1, center);

            int localMaxLength = Math.max(oddPalindromeLength, evenPalindromeLength);
            if (localMaxLength > maxLength) {
                maxLength = localMaxLength;
                from = center - localMaxLength / 2;
                to = center + (localMaxLength - 1) / 2; // adjustment for odd length
            }
        }

        return s.substring(from, to + 1);
    }

    private int extendAndFindLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // both pointers are in incorrect position because of a loop condition
        // return (right - left + 1) - 1 - 1 -> right - left - 1
        return right - left - 1;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public String longestPalindromeViaDP(String s) {
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
