package recursion;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/letter-tile-possibilities
 * Difficulty: Medium
 * Time complexity: O(n!)
 * Space complexity: O(n!)
 */
public class LetterTilePossibilities {

    private int count;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);

        count = 0;
        backtrack(chars, new int[chars.length], 0);
        return count;
    }

    private void backtrack(
            char[] chars,
            int[] used,
            int length) {
        if (length == chars.length) {
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && chars[i] == chars[i - 1] && used[i - 1] == 0) continue;
            count++;

            used[i] = 1;
            backtrack(chars, used, length + 1);
            used[i] = 0;
        }
    }
}
