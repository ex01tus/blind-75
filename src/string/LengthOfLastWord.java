package string;

/**
 * Description: https://leetcode.com/problems/length-of-last-word
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int pointer = s.length() - 1;
        int length = 0;

        while (pointer >= 0 && s.charAt(pointer) == ' ') {
            pointer--;
        }

        while (pointer >= 0 && s.charAt(pointer) != ' ') {
            length++;
            pointer--;
        }

        return length;
    }

    public int lengthOfLastWordViaRegex(String s) {
        String[] words = s.split(" +");
        return words[words.length - 1].length();
    }
}
