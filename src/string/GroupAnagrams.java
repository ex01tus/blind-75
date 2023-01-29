package string;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/group-anagrams
 * Difficulty: Medium
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = countHash(str);
            List<String> words = map.computeIfAbsent(key, __ -> new ArrayList<>());
            words.add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * Time complexity: O(n * k)
     * Space complexity: O(n * k)
     */
    private String countHash(String str) {
        int[] count = new int[26];

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : count) {
            sb.append(c).append("#");
        }

        return sb.toString();
    }

    /**
     * Time complexity: O(n * klog k)
     * Space complexity: O(n * k)
     */
    private String sortHash(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }
}
