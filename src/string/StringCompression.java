package string;

/**
 * Description: https://leetcode.com/problems/string-compression
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class StringCompression {

    public int compress(char[] chars) {
        int pointer = 0;
        int count = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[pointer++] = chars[i - 1];

                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[pointer++] = c;
                    }
                }

                count = 1;
            } else {
                count++;
            }
        }

        return pointer;
    }
}
