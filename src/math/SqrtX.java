package math;

/**
 * Description: https://leetcode.com/problems/sqrtx
 * Difficulty: Easy
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class SqrtX {

    public int mySqrt(int x) {
        if (x < 2) return x;

        // 0 < sqrt(x) < x / 2
        int left = 2;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                // only works if sqrt(x) is an integer
                return mid;
            }
        }

        // we reached the BS out condition
        // -> left > right
        // -> right is the closest value to sqrt(x) rounded down
        return right;
    }
}
