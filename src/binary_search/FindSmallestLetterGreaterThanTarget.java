package binary_search;

/**
 * Description: https://leetcode.com/problems/find-smallest-letter-greater-than-target
 * Difficulty: Easy
 */
public class FindSmallestLetterGreaterThanTarget {

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(1)
     */
    public char nextGreatestLetterViaBinarySearch(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;


        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return letters[result];
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public char nextGreatestLetterViaBruteForce(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }

        return letters[0];
    }
}
