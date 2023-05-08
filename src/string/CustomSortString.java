package string;

/**
 * Description: https://leetcode.com/problems/custom-sort-string
 * Difficulty: Medium
 * Time complexity: O(m + n)
 * Space complexity: O(n)
 */
public class CustomSortString {

    public String customSortStringViaCountingSort(String order, String s) {
        int[] freqMap = buildFreqMap(s);

        StringBuilder sorted = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < freqMap[c - 'a']; i++) {
                sorted.append(c);
            }

            freqMap[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < freqMap[c - 'a']; i++) {
                sorted.append(c);
            }
        }

        return sorted.toString();
    }

    private int[] buildFreqMap(String s) {
        int[] freqMap = new int[26];
        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }

        return freqMap;
    }
}
