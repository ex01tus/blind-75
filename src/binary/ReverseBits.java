package binary;

/**
 * Description: https://leetcode.com/problems/reverse-bits
 * Difficulty: Easy
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = reversed << 1;
            reversed = reversed | (n & 1); // reversed += n & 1;
            n = n >>> 1;
        }

        return reversed;
    }
}
