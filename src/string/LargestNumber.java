package string;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/largest-number
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strings = toStringArray(nums);
        Arrays.sort(strings, (a, b) -> compareStringConcatenations(b, a));

        if (strings[0].equals("0")) return "0"; // edge case for array full of zeroes

        return String.join("", strings);
    }

    private String[] toStringArray(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = "" + nums[i];
        }

        return strings;
    }

    private int compareStringConcatenations(String a, String b) {
        return (a + b).compareTo(b + a); // "10" + "2" = "102" < "210" = "2" + "10"
    }

    /*
    To use sort we should first prove the existence of transitivity property

    Theorem:
    If A.B > B.A and B.C > C.B, than A.C > C.A

    Proof:
    [X] – length of X
    1. A * 10^[B] + B > B * 10^[A] + A
       B * 10^[C] + C > C * 10^[B] + B
    2. A * 10^[B] - A > B * 10^[A] - B
       B * 10^[C] - B > C * 10^[B] - C
    3. A * (10^[B] - 1) > B * (10^[A] - 1)
       B * (10^[C] - 1) > C * (10^[B] - 1)
    4. A * (10^[B] - 1) > B * (10^[A] - 1) > C * (10^[B] - 1)
    5. 10^[X] - 1 > 0
    6. A * (10^[B] - 1) > C * (10^[B] - 1)
    7. A * 10^[B] - A > C * 10^[B] - C
    8. A * 10^[B] + C > C * 10^[B] + A
    9. A.C > C.A

    Q.E.D.
     */
}
