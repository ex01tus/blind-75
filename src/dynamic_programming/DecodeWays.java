package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/decode-ways
 * Difficulty: Medium
 */
public class DecodeWays {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0; // trailing zeroes edge case

        int[] dp = new int[s.length()];
        dp[0] = 1; // first digit always forms a valid combination

        for (int i = 1; i < s.length(); i++) {
            int count = 0;

            // >1< ([0]) 1 2 2 -> (0) is an invalid combination -> >1< can't be used
            // (1 0) ([1]) 2 2 -> (1) is a valid combination -> (1 0) can be used
            int currentDigit = s.charAt(i) - '0';
            if (currentDigit != 0) {
                count += dp[i - 1];
            }

            // ()(1 [0]) 1 2 2 -> (1 0) is a valid combination -> +1
            // >1< (0 [1]) 2 2 -> (0 1) is an invalid combination -> >1< can't be used
            // (1 0) (1 [2]) 2 -> (1 2) is a valid combination -> (1 0) can be used
            // (1 0 1) (2 [2]) -> (2 2) is a valid combination -> (1 0 1) can be used
            int prevDigit = s.charAt(i - 1) - '0';
            int combination = prevDigit * 10 + currentDigit;
            if (prevDigit != 0 && combination < 27) {
                count += i > 1 ? dp[i - 2] : 1;
            }

            dp[i] = count;
        }

        return dp[s.length() - 1];
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int numDecodingsWithNoExtraSpace(String s) {
        if (s.charAt(0) == '0') return 0;

        int oneStepBehind = 1;
        int twoStepsBehind = 1;

        for (int i = 1; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';
            int prevDigit = s.charAt(i - 1) - '0';
            int combination = prevDigit * 10 + currentDigit;

            int count = 0;
            if (currentDigit != 0) {
                count += oneStepBehind;
            }

            if (prevDigit != 0 && combination < 27) {
                count += twoStepsBehind;
            }

            twoStepsBehind = oneStepBehind;
            oneStepBehind = count;
        }

        return oneStepBehind;
    }
}
