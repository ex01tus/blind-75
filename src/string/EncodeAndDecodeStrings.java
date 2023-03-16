package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/encode-and-decode-strings
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class EncodeAndDecodeStrings {

    // ["Hello", "World"] -> "5#Hello5#World"
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length())
                    .append("#")
                    .append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int pointer = 0;
        while (pointer < s.length()) {
            int length = 0;
            while (s.charAt(pointer) != '#') {
                System.out.println(pointer + ":" + s.charAt(pointer));
                length = length * 10 + (s.charAt(pointer) - '0');
                pointer++;
            }

            int start = pointer + 1;
            int end = start + length;
            String str = s.substring(start, end);
            decoded.add(str);
            pointer = end;
        }

        return decoded;
    }
}
