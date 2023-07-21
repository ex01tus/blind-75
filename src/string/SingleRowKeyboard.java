package string;

/**
 * Description: https://leetcode.com/problems/single-row-keyboard
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        int[] keyboardMap = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            keyboardMap[keyboard.charAt(i) - 'a'] = i;
        }

        int prev = 0;
        int time = 0;
        for (int i = 0; i < word.length(); i++) {
            int current = keyboardMap[word.charAt(i) - 'a'];
            time += Math.abs(current - prev);
            prev = current;
        }

        return time;
    }
}
