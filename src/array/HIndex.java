package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/h-index
 * Difficulty: Medium
 */
public class HIndex {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int hIndexViaCountingSort(int[] citations) {
        // by definition hIndex can only be in range [0; N]
        int[] freqMap = new int[citations.length + 1];
        for (int citation : citations) {
            freqMap[Math.min(citation, citations.length)]++;
        }

        // check every possible hIndex, starting from the highest
        int citationsNumber = 0;
        for (int hIndex = freqMap.length - 1; hIndex >= 0; hIndex--) {
            citationsNumber += freqMap[hIndex];
            if (citationsNumber >= hIndex) return hIndex;
        }

        return 0;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int hIndexViaSorting(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > hIndex) {
                hIndex++;
            } else {
                break;
            }
        }

        return hIndex;
    }
}
