package binary_search;

/**
 * Description: https://leetcode.com/problems/koko-eating-bananas
 * Difficulty: Medium
 * Time complexity: O(n log(Integer.MAX_VALUE))
 * Space complexity: O(1)
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int hours) {
        int minSpeed = 1;
        int maxSpeed = Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatAllBananas(piles, hours, midSpeed)) {
                min = Math.min(min, midSpeed);
                maxSpeed = midSpeed - 1;
            } else {
                minSpeed = midSpeed + 1;
            }
        }

        return min;
    }

    private boolean canEatAllBananas(int[] piles, int totalTime, int speed) {
        int currentTime = 0;

        for (int pile : piles) {
            currentTime += pile / speed;
            currentTime += pile % speed == 0 ? 0 : 1;
            if (currentTime > totalTime) return false;
        }

        return true;
    }
}
