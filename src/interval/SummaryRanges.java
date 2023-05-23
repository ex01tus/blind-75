package interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/summary-ranges
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return List.of();

        List<String> ranges = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end = nums[i];
            } else {
                ranges.add(buildRange(start, end));
                start = nums[i];
                end = nums[i];
            }
        }

        ranges.add(buildRange(start, end));
        return ranges;
    }

    private String buildRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
