package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/find-the-duplicate-number
 * Difficulty: Medium
 */
public class FindTheDuplicateNumber {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int findDuplicateViaFloydAlgo(int[] nums) {
        int intersection = detectCycle(nums);
        return findCycleStart(nums, intersection);
    }

    private int detectCycle(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        return slow;
    }

    private int findCycleStart(int[] nums, int intersection) {
        int slow = 0;

        while (intersection != slow) {
            intersection = nums[intersection];
            slow = nums[slow];
        }

        return slow;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int findDuplicateNaiveApproachViaSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return num;
        }

        return -1;
    }
}
