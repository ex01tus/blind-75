package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/longest-consecutive-sequence
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numsSet.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (numsSet.contains(num - 1)) continue; // num is not the start of a sequence

            int count = 1;
            int next = num + 1;
            while (numsSet.contains(next)) {
                count++;
                next++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
