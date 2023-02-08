package string;

/**
 * Description: https://leetcode.com/problems/one-edit-distance
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String first, String second) {
        if (first.length() > second.length()) return isOneEditDistance(second, first);

        if (second.length() - first.length() > 2) return false;

        boolean hasEdit = false;
        int i = 0;
        int j = 0;

        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (hasEdit) return false;
                hasEdit = true;

                if (first.length() == second.length()) i++;
                j++;
            }
        }

        return true;
    }
}
