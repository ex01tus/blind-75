package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/word-pattern
 * Difficulty: Easy
 * Time complexity: O(m)
 * Space complexity: O(m + 26)
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<String, Character> wordToChar = new HashMap<>();
        Map<Character, String> charToWord = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);

            if (!wordToChar.containsKey(word)
                    && !charToWord.containsKey(c)) {
                wordToChar.put(word, c);
                charToWord.put(c, word);
            } else if (!Objects.equals(wordToChar.get(word), c)
                    || !Objects.equals(charToWord.get(c), word)) {
                return false;
            }
        }

        return true;
    }
}
