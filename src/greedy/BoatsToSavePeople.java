package greedy;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/boats-to-save-people
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(log n)
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int light = 0;
        int heavy = people.length - 1;

        int boats = 0;
        while (light <= heavy) {
            boats++;

            if (people[heavy] + people[light] <= limit) {
                light++; // if possible, take light person together with the heavy one
            }

            heavy--;
        }

        return boats;
    }
}
