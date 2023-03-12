package binary;

/**
 * Description: https://leetcode.com/problems/sum-of-two-integers
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int carry = 0;

        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }

    /*
    1001 + 1011
    1. 1001  &  1011 =  1001 // carry
       1001  ^  1011 =  0010 // a
       1001  <<    1 = 10010 // b
    2. 0010  & 10010 = 00010
       0010  ^ 10010 = 10000
       00010 <<    1 = 00100
    3. 00100 & 10000 = 00000
       00100 ^ 10000 = 10100 // result
       00000 <<    1 = 00000
     */
}
