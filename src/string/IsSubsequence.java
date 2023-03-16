package string;

/**
 * Description: https://leetcode.com/problems/is-subsequence
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int first = 0;
        int second = 0;

        while (first < s.length() && second < t.length()) {
            if (s.charAt(first) == t.charAt(second)) {
                first++;
            }

            second++;
        }

        return first == s.length();
    }
}
