package greedy;

/**
 * Description: https://leetcode.com/problems/can-place-flowers
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowersWithoutInputModification(int[] flowerbed, int n) {
        int current = 0;
        while (current < flowerbed.length && n > 0) {
            if (flowerbed[current] == 0
                    && (current == 0 || flowerbed[current - 1] == 0)
                    && (current == flowerbed.length - 1 || flowerbed[current + 1] == 0)) {
                n--;
                current += 2;
            } else {
                current += 1;
            }
        }


        return n == 0;
    }

    public boolean canPlaceFlowersWithInputModification(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
