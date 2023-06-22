package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(log n)
 */
public class HowManyApplesCanYouPutIntoTheBasket {

    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);

        int count = 0;
        int total = 0;
        for (int apple : weight) {
            total += apple;
            if (total > 5000) return count;
            count++;
        }

        return count;
    }
}
