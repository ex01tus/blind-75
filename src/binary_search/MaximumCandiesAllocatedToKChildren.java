package binary_search;

/**
 * Description: https://leetcode.com/problems/maximum-candies-allocated-to-k-children
 * Difficulty: Medium
 * Time complexity: O(n log(Integer.MAX_VALUE))
 * Space complexity: O(1)
 */
public class MaximumCandiesAllocatedToKChildren {

    public int maximumCandies(int[] candies, long children) {
        int minAllocation = 0;
        int maxAllocation = Integer.MAX_VALUE;

        // Possible optimization:
        // int maxAllocation = Arrays.stream(candies).max().getAsInt();

        int max = 0;
        while (minAllocation <= maxAllocation) {
            int midAllocation = minAllocation + (maxAllocation - minAllocation) / 2;

            if (canAllocateCandyToEveryChild(candies, children, midAllocation)) {
                max = Math.max(max, midAllocation);
                minAllocation = midAllocation + 1;
            } else {
                maxAllocation = midAllocation - 1;
            }
        }

        return max;
    }

    private boolean canAllocateCandyToEveryChild(int[] candies, long totalChildren, int candiesPerChild) {
        if (candiesPerChild == 0) return true;

        long childrenWithCandies = 0;
        for (int pile : candies) {
            childrenWithCandies += pile / candiesPerChild;
            if (childrenWithCandies >= totalChildren) return true;
        }

        return false;
    }
}
