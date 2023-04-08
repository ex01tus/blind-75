package string;

/**
 * Description: https://leetcode.com/problems/long-pressed-name
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int namePointer = 0;
        for (int typedPointer = 0; typedPointer < typed.length(); typedPointer++) {
            if (namePointer < name.length()
                    && name.charAt(namePointer) == typed.charAt(typedPointer)) {
                namePointer++;
            } else if (typedPointer == 0
                    || typed.charAt(typedPointer - 1) != typed.charAt(typedPointer)) {
                return false;
            }
        }

        return namePointer == name.length();
    }
}
