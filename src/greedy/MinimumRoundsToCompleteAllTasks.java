package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumRoundsToCompleteAllTasks {

    public int minimumRoundsViaMath(int[] tasks) {
        Map<Integer, Integer> freqMap = buildFreqMap(tasks);

        int rounds = 0;
        for (int freq : freqMap.values()) {
            if (freq == 1) return -1;

            if (freq % 3 == 0) {
                rounds += freq / 3;
            } else {
                // freq % 3 == 1 -> freq / 3 - 1 + 2
                // freq % 3 == 2 -> freq / 3 + 1
                rounds += freq / 3 + 1;
            }
        }

        return rounds;
    }

    public int minimumRoundsViaNaiveLoop(int[] tasks) {
        Map<Integer, Integer> freqMap = buildFreqMap(tasks);

        int rounds = 0;
        for (int freq : freqMap.values()) {
            if (freq % 3 == 0) {
                rounds += freq / 3;
                continue;
            }

            while (freq != 0) {
                if (freq - 3 >= 2) {
                    freq -= 3;
                    rounds++;
                } else if (freq - 2 >= 0) {
                    freq -= 2;
                    rounds++;
                } else {
                    return -1;
                }
            }
        }

        return rounds;
    }

    private Map<Integer, Integer> buildFreqMap(int[] tasks) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int task : tasks) {
            freqMap.merge(task, 1, Integer::sum);
        }

        return freqMap;
    }
}
