package binary;

/**
 * Description: https://leetcode.com/problems/bitwise-and-of-numbers-range
 * Difficulty: Medium
 */
public class BitwiseAndOfNumbersRange {

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int rangeBitwiseAndViaCommonPrefix(int left, int right) {
        // Result of an AND operation on range is a common prefix with the rest of the bits as zeroes
        //  9 = [00001] 001
        // 10 = [00001] 010
        // 11 = [00001] 011
        // 12 = [00001] 100
        // ----------------
        // &    [00001] 000

        int shift = 0;
        while (left != right) {
            // shift to the right, until common prefix is found
            left = left >> 1;
            right = right >> 1;
            shift++;
        }

        // shift to the left to place an appropriate amount of zero bits
        return left << shift;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int rangeBitwiseAndNaiveApproach(int left, int right) {
        int result = left;
        for (int i = left + 1; i <= right; i++) {
            result &= i;
        }

        return result;
    }
}
