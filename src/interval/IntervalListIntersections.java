package interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/interval-list-intersections
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();

        int firstPointer = 0;
        int secondPointer = 0;

        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int[] firstInterval = firstList[firstPointer];
            int[] secondInterval = secondList[secondPointer];

            if (firstInterval[0] <= secondInterval[1] && secondInterval[0] <= firstInterval[1]) {
                intersections.add(new int[]{
                        Math.max(firstInterval[0], secondInterval[0]),
                        Math.min(firstInterval[1], secondInterval[1])});
            }

            if (firstInterval[1] < secondInterval[1]) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }

        return intersections.toArray(new int[0][]);
    }
}
