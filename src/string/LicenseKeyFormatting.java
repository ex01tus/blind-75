package string;

/**
 * Description: https://leetcode.com/problems/license-key-formatting
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder formatted = new StringBuilder();
        int currentGroupSize = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            formatted.append(Character.toUpperCase(s.charAt(i)));

            if (++currentGroupSize == k) {
                formatted.append("-");
                currentGroupSize = 0;
            }
        }

        if (formatted.length() > 0 && formatted.charAt(formatted.length() - 1) == '-') {
            formatted.deleteCharAt(formatted.length() - 1);
        }

        return formatted.reverse().toString();
    }
}
