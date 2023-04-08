package binary_search;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/successful-pairs-of-spells-and-potions
 * Difficulty: Medium
 */
public class SuccessfulPairsOfSpellsAndPotions {

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int[] successfulPairsViaBinarySearch(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            pairs[i] = countSuccessfulPairs(spells[i], potions, success);
        }

        return pairs;
    }

    private int countSuccessfulPairs(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;
        int leftmostValidPotion = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long cast = (long) spell * potions[mid];

            if (cast >= success) {
                right = mid - 1;
                leftmostValidPotion = mid;
            } else {
                left = mid + 1;
            }
        }

        return leftmostValidPotion == -1 ? 0 : potions.length - leftmostValidPotion;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int[] successfulPairsNaiveApproach(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int successCounter = 0;
            for (int potion : potions) {
                long cast = (long) spells[i] * potion;
                if (cast >= success) successCounter++;
            }

            pairs[i] = successCounter;
        }

        return pairs;
    }
}
