package string;

/**
 * Description: https://leetcode.com/problems/shuffle-string
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] shuffled = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            shuffled[indices[i]] = s.charAt(i);
        }

        return new String(shuffled);
    }
}
