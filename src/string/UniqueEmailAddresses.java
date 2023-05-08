package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/unique-email-addresses
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            uniqueEmails.add(transform(email));
        }

        return uniqueEmails.size();
    }

    private String transform(String email) {
        String[] parts = email.split("@", 2);
        StringBuilder transformed = new StringBuilder();
        for (char c : parts[0].toCharArray()) {
            if (c == '+') break;
            if (c != '.') transformed.append(c);
        }

        return transformed.append('@').append(parts[1]).toString();
    }
}
