package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/isomorphic-strings
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class IsomorphicStrings {

    public boolean isIsomorphicViaIndexMapping(String first, String second) {
        int[] firstToSecond = new int[256];
        int[] secondToFirst = new int[256];

        for (int i = 0; i < first.length(); i++) {
            if (firstToSecond[first.charAt(i)] != secondToFirst[second.charAt(i)]) {
                return false;
            }

            firstToSecond[first.charAt(i)] = i + 1;
            secondToFirst[second.charAt(i)] = i + 1;
        }

        return true;
    }

    public boolean isIsomorphicViaCharMapping(String first, String second) {
        Map<Character, Character> firstToSecond = new HashMap<>();
        Map<Character, Character> secondToFirst = new HashMap<>();

        for (int i = 0; i < first.length(); i++) {
            Character firstChar = first.charAt(i);
            Character secondChar = second.charAt(i);

            if (!firstToSecond.containsKey(firstChar)
                    && !secondToFirst.containsKey(secondChar)) {
                firstToSecond.put(firstChar, secondChar);
                secondToFirst.put(secondChar, firstChar);
            } else if (firstToSecond.get(firstChar) != secondChar
                    || secondToFirst.get(secondChar) != firstChar) {
                return false;
            }
        }

        return true;
    }
}
