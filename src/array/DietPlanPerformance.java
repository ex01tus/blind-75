package array;

/**
 * Description: https://leetcode.com/problems/diet-plan-performance
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class DietPlanPerformance {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int eaten = 0;

        int left = 0;
        for (int right = 0; right < calories.length; right++) {
            eaten += calories[right];

            if (right - left + 1 > k) {
                eaten -= calories[left];
                left++;
            }

            if (right >= k - 1) {
                points += assessPerformance(eaten, lower, upper);
            }
        }

        return points;
    }

    private int assessPerformance(int eaten, int lower, int upper) {
        if (eaten < lower) return -1;
        if (eaten > upper) return 1;
        return 0;
    }
}
