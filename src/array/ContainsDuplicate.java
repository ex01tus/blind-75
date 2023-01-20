package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/contains-duplicate
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }

        return false;
    }
}
