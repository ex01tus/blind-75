package string;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/find-all-anagrams-in-a-string
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindAllAnagramsInString {

    public List<Integer> findAnagramsWithTwoCharMaps(String line, String anagram) {
        if (anagram.length() > line.length()) return List.of();

        List<Integer> positions = new ArrayList<>();

        int left = 0;
        int right = 0;

        int[] windowMap = new int[26];
        int[] anagramMap = new int[26];

        while (right < anagram.length()) {
            windowMap[line.charAt(right) - 'a']++;
            anagramMap[anagram.charAt(right) - 'a']++;
            right++;
        }

        if (Arrays.equals(windowMap, anagramMap)) {
            positions.add(0);
        }

        while (right < line.length()) {
            windowMap[line.charAt(right) - 'a']++;
            windowMap[line.charAt(left) - 'a']--;

            left++;
            right++;

            // comparing two arrays takes O(26) time ->  final time complexity is O(26 * n) -> O(n)
            if (Arrays.equals(windowMap, anagramMap)) {
                positions.add(left);
            }
        }

        return positions;
    }

    public List<Integer> findAnagramsWithSingleCharMap(String line, String anagram) {
        Map<Character, Integer> charMap = toCharMap(anagram);

        int left = 0;
        int right = 0;

        List<Integer> positions = new ArrayList<>();
        int charsToFind = charMap.size();

        while (right < line.length()) {
            char rightChar = line.charAt(right);
            if (charMap.containsKey(rightChar)) {
                int rightCharCount = charMap.get(rightChar);
                if (rightCharCount == 1) {
                    charsToFind--;
                }
                charMap.put(rightChar, rightCharCount - 1);
            }
            right++;

            if (right - left > anagram.length()) { // time to move left side of the window
                char leftChar = line.charAt(left);
                if (charMap.containsKey(leftChar)) {
                    int leftCharCount = charMap.get(leftChar);
                    if (leftCharCount == 0) {
                        charsToFind++;
                    }
                    charMap.put(leftChar, leftCharCount + 1);
                }
                left++;
            }

            if (charsToFind == 0) {
                positions.add(left);
            }
        }

        return positions;
    }

    private Map<Character, Integer> toCharMap(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            charMap.merge(c, 1, Integer::sum);
        }

        return charMap;
    }
}
