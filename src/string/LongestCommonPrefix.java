package string;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/longest-common-prefix
 * Difficulty: Easy
 */
public class LongestCommonPrefix {

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(m)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        String first = strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || first.charAt(i) != strs[j].charAt(i)) {
                    return result.toString();
                }
            }

            result.append(first.charAt(i));
        }

        return result.toString();
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(m)
     */
    public String longestCommonPrefixViaSorting(String[] strs) {
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int counter = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                counter++;
            } else {
                break;
            }
        }

        return first.substring(0, counter);
    }
}
