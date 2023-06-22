package greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/dota2-senate
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantSenator = radiant.poll();
            int direSenator = dire.poll();

            // the one with the larger index is BANNED by the one with the smaller one
            if (radiantSenator > direSenator) {
                // make sure this senator won't vote again in the same round
                dire.offer(direSenator + senate.length());
            } else {
                radiant.offer(radiantSenator + senate.length());
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
