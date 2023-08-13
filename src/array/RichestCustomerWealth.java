package array;

/**
 * Description: https://leetcode.com/problems/richest-customer-wealth
 * Difficulty: Easy
 * Time complexity: O(n * m)
 * Space complexity: O(1)
 */
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int account : customer) {
                wealth += account;
            }

            max = Math.max(max, wealth);
        }

        return max;
    }
}
