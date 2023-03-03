package string;

/**
 * Description: https://leetcode.com/problems/add-strings
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int first = num1.length() - 1;
        int second = num2.length() - 1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = carry;
            if (first >= 0) {
                sum += num1.charAt(first) - '0';
                first--;
            }

            if (second >= 0) {
                sum += num2.charAt(second) - '0';
                second--;
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
