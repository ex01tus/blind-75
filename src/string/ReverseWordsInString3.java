package string;

/**
 * Description: https://leetcode.com/problems/reverse-words-in-a-string-iii
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ReverseWordsInString3 {

    public String reverseWords(String s) {
        int left = 0;
        int right = 0;

        char[] arr = s.toCharArray();
        while (right < arr.length) {
            while (right < arr.length && arr[right] != ' ') {
                right++;
            }

            reverse(arr, left, right - 1);
            left = right + 1;
            right++;
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
