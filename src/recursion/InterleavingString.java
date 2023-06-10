package recursion;

/**
 * Description: https://leetcode.com/problems/interleaving-string
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0, new int[s1.length()][s2.length()]);
    }

    private boolean isInterleave(String s1, String s2, String s3, int p1, int p2, int[][] seen) {
        int p3 = p1 + p2;

        if (p1 == s1.length()) return s2.substring(p2).equals(s3.substring(p3));
        if (p2 == s2.length()) return s1.substring(p1).equals(s3.substring(p3));
        if (seen[p1][p2] != 0) return false; // we've already been here and weren't able to find an answer

        seen[p1][p2] = 1;

        boolean takeFirst = s3.charAt(p3) == s1.charAt(p1) && isInterleave(s1, s2, s3, p1 + 1, p2, seen);
        boolean takeSecond = s3.charAt(p3) == s2.charAt(p2) && isInterleave(s1, s2, s3, p1, p2 + 1, seen);;

        return takeFirst || takeSecond;
    }
}
