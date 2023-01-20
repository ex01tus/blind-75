package binary_search;

/**
 * Description: https://leetcode.com/problems/first-bad-version
 * Difficulty: Easy
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
