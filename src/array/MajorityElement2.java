package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/majority-element-ii
 * Difficulty: Medium
 */
public class MajorityElement2 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public List<Integer> majorityElementViaMooreAlgo(int[] nums) {
        int count1 = 0;
        int count2 = 0;

        // there can only be 2 elements that appear more than n/3 times
        int candidate1 = nums[0];
        int candidate2 = nums[0];

        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // second pass to check, if candidates really appear more than n/3 times
        return checkCandidatesFrequency(nums, candidate1, candidate2);
    }

    private List<Integer> checkCandidatesFrequency(int[] nums, int candidate1, int candidate2) {
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length / 3;
        List<Integer> result = new ArrayList<>();

        if (count1 > n) result.add(candidate1);
        if (count2 > n) result.add(candidate2);

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(m)
     */
    public List<Integer> majorityElementViaMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > n) result.add(entry.getKey());
        }

        return result;
    }
}
