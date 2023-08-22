package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximum-units-on-a-truck
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class MaximumUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Box> boxes = new ArrayList<>();
        for (int[] box : boxTypes) {
            boxes.add(new Box(box[0], box[1]));
        }
        boxes.sort((a, b) -> Integer.compare(b.units, a.units));

        int units = 0;
        for (Box box : boxes) {
            int number = Math.min(truckSize, box.number);
            units += number * box.units;
            truckSize -= number;

            if (truckSize == 0) break;
        }

        return units;
    }

    private record Box(int number, int units) {}
}
