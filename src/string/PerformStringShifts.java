package string;

/**
 * Description: https://leetcode.com/problems/perform-string-shifts
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class PerformStringShifts {

    public String stringShift(String s, int[][] shifts) {
        int netShift = 0;
        for (int[] shift : shifts) {
            int direction = shift[0] == 0 ? -1 : 1;
            netShift += direction * shift[1];
        }

        netShift %= s.length();
        if (netShift == 0) return s;

        return netShift < 0
                ? s.substring(-netShift) + s.substring(0, -netShift) // move left
                : s.substring(s.length() - netShift) + s.substring(0, s.length() - netShift); // move right
    }
}
