package string;

/**
 * Description: https://leetcode.com/problems/palindrome-permutation
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int[] freqMap = new int[26];
        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }

        boolean isOddFound = false;
        for (int freq : freqMap) {
            if (freq % 2 != 0) {
                if (isOddFound) return false;
                isOddFound = true;
            }
        }

        return true;
    }
}
