package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/distribute-candies
 * Difficulty: Easy
 */
public class DistributeCandies {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int distributeCandiesViaSet(int[] candyType) {
        Set<Integer> eaten = new HashSet<>();
        int candiesLeft = candyType.length / 2;

        for (int candy : candyType) {
            if (eaten.add(candy)) {
                if (--candiesLeft == 0) break;
            }
        }

        return eaten.size();
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int distributeCandiesViaSorting(int[] candyType) {
        Arrays.sort(candyType);

        int candiesLeft = candyType.length / 2;
        int eaten = 0;
        for (int i = 0; i < candyType.length; i++) {
            if (i > 0 && candyType[i - 1] == candyType[i]) continue;
            eaten++;
            if (--candiesLeft == 0) break;
        }

        return eaten;
    }
}
