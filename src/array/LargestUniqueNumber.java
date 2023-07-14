package array;

/**
 * Description: https://leetcode.com/problems/largest-unique-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LargestUniqueNumber {

    public int largestUniqueNumber(int[] nums) {
        int[] freqMap = new int[1001];
        for (int num : nums) {
            freqMap[num]++;
        }

        for (int x = 1000; x > 0; x--) {
            if (freqMap[x] == 1) return x;
        }

        return -1;
    }
}
