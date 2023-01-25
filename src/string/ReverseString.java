package string;

/**
 * Description: https://leetcode.com/problems/reverse-string
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
