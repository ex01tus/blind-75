package array;

/**
 * Description: https://leetcode.com/problems/pour-water
 * Difficulty: Medium
 * Time complexity: O(volume * n)
 * Space complexity: O(1)
 */
public class PourWater {

    public int[] pourWater(int[] heights, int volume, int k) {
        int currentWaterPosition = k;
        for (int drop = 0; drop < volume; drop++) {

            // move droplet to the left
            while (currentWaterPosition > 0
                    && heights[currentWaterPosition] >= heights[currentWaterPosition - 1]) {
                currentWaterPosition--;
            }

            // move droplet to the right
            while (currentWaterPosition < heights.length - 1
                    && heights[currentWaterPosition] >= heights[currentWaterPosition + 1]) {
                currentWaterPosition++;
            }

            // move droplet back to the left if we have a plain terrain on the right
            while (currentWaterPosition > k
                    && heights[currentWaterPosition] == heights[currentWaterPosition - 1]) {
                currentWaterPosition--;
            }

            heights[currentWaterPosition] += 1;
        }

        return heights;
    }
}
