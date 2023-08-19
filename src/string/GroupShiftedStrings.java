package string;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/group-shifted-strings
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class GroupShiftedStrings {

    private static final int ALPHABET_SIZE = 26;

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strings) {
            groups.computeIfAbsent(hash(s), __ -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    private String hash(String s) {
        int[] hash = new int[s.length()];

        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            hash[i] = getShiftFromFirstChar(s.charAt(i), first);
        }

        return Arrays.toString(hash);
    }

    private int getShiftFromFirstChar(char current, char first) {
        // add 26 not to have negative values
        return (current - first + ALPHABET_SIZE) % ALPHABET_SIZE;
    }
}
