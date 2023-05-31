package greedy;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/earliest-possible-day-of-full-bloom
 * Difficulty: Hard
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class EarliestPossibleDayOfFullBloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // first plant the ones, that take the longest time to grow
        Seed[] seeds = toSeedsSortedByLongestGrowTime(plantTime, growTime);

        int currentPlantTime = 0;
        int earliestBloom = 0;
        for (Seed seed : seeds) {
            int timeSpentSoFar = currentPlantTime + seed.plantTime + seed.growTime;
            earliestBloom = Math.max(earliestBloom, timeSpentSoFar);
            currentPlantTime += seed.plantTime;
        }

        return earliestBloom;
    }

    private Seed[] toSeedsSortedByLongestGrowTime(int[] plantTime, int[] growTime) {
        Seed[] seeds = new Seed[plantTime.length];
        for (int i = 0; i < plantTime.length; i++) {
            seeds[i] = new Seed(plantTime[i], growTime[i]);
        }

        Arrays.sort(seeds, (a, b) -> Integer.compare(b.growTime, a.growTime));

        return seeds;
    }

    private record Seed(int plantTime, int growTime) {
    }
}
