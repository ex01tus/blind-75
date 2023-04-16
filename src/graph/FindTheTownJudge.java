package graph;

/**
 * Description: https://leetcode.com/problems/find-the-town-judge
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] trustedBy = new int[n + 1];

        for (int[] relation : trust) {
            trusts[relation[0]]++;
            trustedBy[relation[1]]++;
        }

        for (int man = 1; man <= n; man++) {
            if (trusts[man] == 0 && trustedBy[man] == n - 1) {
                return man;
            }
        }

        return -1;
    }
}
