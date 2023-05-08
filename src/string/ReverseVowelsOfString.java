package string;

import java.util.Set;

/**
 * Description: https://leetcode.com/problems/reverse-vowels-of-a-string
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'u', 'o', 'A', 'E', 'I', 'U', 'O');
        int left = 0;
        int right = s.length() - 1;

        char[] input = s.toCharArray();
        while (left < right) {
            if (!vowels.contains(input[left])) {
                left++;
            } else if (!vowels.contains(input[right])) {
                right--;
            } else {
                swap(input, left, right);
                left++;
                right--;
            }
        }

        return new String(input);
    }

    private void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
