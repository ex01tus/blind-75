package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/prison-cells-after-n-days
 * Difficulty: Medium
 * Time complexity: O(cells * min(days, 2^cells))
 * Space complexity: O(min(days, 2^cells))
 */
public class PrisonCellAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int days) {
        Map<Integer, Integer> stateToDayCache = new HashMap<>();
        boolean isFastForwarded = false;
        while (days > 0) {
            if (!isFastForwarded) {
                int currentState = buildState(cells);
                if (stateToDayCache.containsKey(currentState)) {
                    // pattern (cycle) was found -> fast forward
                    days = days % (stateToDayCache.get(currentState) - days);
                    isFastForwarded = true;
                } else {
                    stateToDayCache.put(currentState, days);
                }
            }

            if (days > 0) {
                cells = nextDay(cells);
                days--;
            }
        }

        return cells;
    }

    private int[] nextDay(int[] prevDay) {
        int[] nextDay = new int[prevDay.length];
        nextDay[0] = 0;
        nextDay[nextDay.length - 1] = 0;

        for (int cell = 1; cell < nextDay.length - 1; cell++) {
            nextDay[cell] = prevDay[cell - 1] == prevDay[cell + 1] ? 1 : 0;
        }

        return nextDay;
    }

    private int buildState(int[] cells) {
        int state = 0;
        for (int cell : cells) {
            state = state << 1;
            state = state | cell;
        }

        return state;
    }
}
