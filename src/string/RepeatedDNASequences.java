package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/repeated-dna-sequences
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RepeatedDNASequences {

    private static final int SEQUENCE_LENGTH = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int start = 0; start < s.length() - SEQUENCE_LENGTH + 1; start++) {
            // substring takes O(10) -> O(1) time
            String sequence = s.substring(start, start + SEQUENCE_LENGTH);
            if (!seen.add(sequence)) repeated.add(sequence);
        }

        return new ArrayList<>(repeated);
    }
}
