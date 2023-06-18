package string;

/**
 * Description: https://leetcode.com/problems/greatest-common-divisor-of-strings
 * Difficulty: Easy
 * Time complexity: O(min(m, n) * (m + n))
 * Space complexity: O(min(m, n))
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            if (isGcd(str1, str2, i)) return str1.substring(0, i);
        }

        return "";
    }

    private boolean isGcd(String str1, String str2, int i) {
        if (str1.length() % i != 0 || str2.length() % i != 0) return false;

        String candidate = str1.substring(0, i);
        return str1.replaceAll(candidate, "").isEmpty()
                && str2.replaceAll(candidate, "").isEmpty();
    }
}
