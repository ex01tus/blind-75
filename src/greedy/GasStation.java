package greedy;

/**
 * Description: https://leetcode.com/problems/gas-station
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class GasStation {

    public int canCompleteCircuitWithTwoLoops(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if (totalGas < totalCost) return -1; // not enough gas to complete the circuit

        int start = 0;
        int remainingGas = 0;
        for (int i = 0; i < gas.length; i++) {
            remainingGas += gas[i] - cost[i];
            if (remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
        }

        return start;
    }

    public int canCompleteCircuitWithSingleLoop(int[] gas, int[] cost) {
        int start = 0;
        int remainingGas = 0;
        int circuitTotalGas = 0;

        for (int i = 0; i < gas.length; i++) {
            circuitTotalGas += gas[i] - cost[i];
            remainingGas += gas[i] - cost[i];
            if (remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
        }

        return circuitTotalGas < 0 ? -1 : start;
    }
}
