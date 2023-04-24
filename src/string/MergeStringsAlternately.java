package string;

/**
 * Description: https://leetcode.com/problems/merge-strings-alternately
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(m + n)
 */
public class MergeStringsAlternately {
    
    public String mergeAlternately(String first, String second) {
        int i = 0;
        int j = 0;
        StringBuilder merged = new StringBuilder();
        while (i < first.length() || j < second.length()) {
            if (i < first.length()) {
                merged.append(first.charAt(i));
                i++;
            }

            if (j < second.length()) {
                merged.append(second.charAt(j));
                j++;
            }
        }

        return merged.toString();
    }
}
