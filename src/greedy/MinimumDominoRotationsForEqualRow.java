package greedy;

/**
 * Description: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = countRotations(tops, bottoms, bottoms[0]);
        if (rotations != -1 || tops[0] == bottoms[0]) return rotations;

        return countRotations(tops, bottoms, tops[0]);
    }

    private int countRotations(int[] first, int[] second, int val) {
        int firstRotations = 0;
        int secondRotations = 0;

        for (int i = 0; i < first.length; i++) {
            if (first[i] != val && second[i] != val) return -1;

            if (first[i] != val) {
                firstRotations++;
            } else if (second[i] != val) {
                secondRotations++;
            }
        }

        return Math.min(firstRotations, secondRotations);
    }
}
