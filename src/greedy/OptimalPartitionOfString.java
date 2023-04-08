package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/optimal-partition-of-string
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class OptimalPartitionOfString {

    public int partitionString(String s) {
        int count = 1;
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                count++;
                seen.clear();
            }

            seen.add(c);
        }

        return count;
    }
}
