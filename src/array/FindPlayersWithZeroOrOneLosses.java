package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/find-players-with-zero-or-one-losses
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> playerToLosses = new TreeMap<>();
        for (int[] match : matches) {
            playerToLosses.putIfAbsent(match[0], 0);
            playerToLosses.merge(match[1], 1, Integer::sum);
        }

        List<List<Integer>> winners = List.of(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : playerToLosses.entrySet()) {
            int player = entry.getKey();
            int losses = entry.getValue();

            if (losses == 0) {
                winners.get(0).add(player);
            } else if (losses == 1) {
                winners.get(1).add(player);
            }
        }

        return winners;
    }
}
