package string;

/**
 * Description: https://leetcode.com/problems/multiply-strings
 * Difficulty: Medium
 */
public class MultiplyStrings {

    /**
     * Time complexity: O(m * n)
     * Space complexity: O(m + n)
     */
    public String multiplyOptimalApproach(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int[] result = new int[a.length() + b.length()];

        for (int i = 0; i < a.length(); i++) {
            int aDigit = a.charAt(i) - '0';
            for (int j = 0; j < b.length(); j++) {
                int bDigit = b.charAt(j) - '0';

                int position = i + j; // main "trick"
                int mult = aDigit * bDigit + result[position];
                result[position] = mult % 10;
                result[position + 1] += mult / 10; // carry
            }
        }

        return toString(result);
    }

    private String toString(int[] result) {
        StringBuilder stringResult = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (stringResult.isEmpty() && result[i] == 0) continue; // skip trailing zeroes
            stringResult.append(result[i]);
        }

        return stringResult.isEmpty() ? "0" : stringResult.toString();
    }

    /**
     * Time complexity: O(m * (m + n))
     * Space complexity: O(m + n)
     */
    public String multiplyViaElementaryMath(String a, String b) {
        String result = mult(a, b);
        if (result.charAt(0) == '0') return "0";

        return result;
    }

    // takes O(m * n) time
    private String mult(String a, String b) {
        String finalResult = "0";
        for (int i = b.length() - 1; i >= 0; i--) {
            StringBuilder result = new StringBuilder();

            int digit = b.charAt(i) - '0';
            int carry = 0;

            // pad zeroes
            for (int k = i; k < b.length() - 1; k++) {
                result.append(0);
            }

            for (int j = a.length() - 1; j >= 0; j--) {
                int mult = carry + digit * (a.charAt(j) - '0');
                result.append(mult % 10);
                carry = mult / 10;
            }

            if (carry != 0) {
                result.append(carry);
            }

            String multiplicationResult = result.reverse().toString();
            finalResult = sum(finalResult, multiplicationResult);
        }

        return finalResult;
    }

    // takes O(m +n) time and is called m times
    private String sum(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while (i >=0 || j >=0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
