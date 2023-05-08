package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/find-the-winner-of-the-circular-game
 * Difficulty: Medium
 */
public class FindWinnerOfTheCircularGame {

    /**
     * Time complexity: O(n * k)
     * Space complexity: O(n)
     */
    public int findTheWinnerViaQueue(int n, int k) {
        Queue<Integer> players = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            players.offer(i);
        }

        while (players.size() > 1) {
            int looser = (k - 1) % players.size();
            for (int i = 0; i < looser; i++) {
                players.offer(players.poll()); // "rotate" players
            }

            players.poll(); // remove looser
        }

        return players.poll() + 1;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public int findTheWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();
        for (int player = 0; player < n; player++) {
            players.add(player);
        }

        int current = 0;
        while (players.size() > 1) {
            int looser = (current + k - 1) % players.size();
            players.remove(looser); // takes O(n) time
            current = looser;
        }

        return players.get(0) + 1;
    }
}
