package binary;

/**
 * Description: https://leetcode.com/problems/add-binary
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int aPointer = a.length() - 1;
        int bPointer = a.length() - 1;

        StringBuilder result = new StringBuilder();

        int carry = 0;
        while (aPointer >= 0 || bPointer >= 0) {
            int sum = carry;
            if (aPointer >= 0) {
                sum += Character.getNumericValue(a.charAt(aPointer));
                aPointer--;
            }

            if (bPointer >= 0) {
                sum += Character.getNumericValue(b.charAt(bPointer));
                bPointer--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(1);
        }

        return result.reverse().toString();
    }
}
