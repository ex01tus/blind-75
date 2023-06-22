package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/candy
 * Difficulty: Hard
 */
public class Candy {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int candyViaTwoPasses(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // go right and make sure each child with higher rating has more candies than his left neighbor
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        // go left and make sure each child with higher rating has more candies than his right neighbor
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }

        // count the total number of candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(n)
     */
    public int candyViaMinHeap(int[] ratings) {
        Queue<Child> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.rating));
        for (int i = 0; i < ratings.length; i++) {
            minHeap.offer(new Child(ratings[i], i));
        }

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        int total = 0;
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll().index;

            if (current > 0 && ratings[current - 1] < ratings[current]) {
                candies[current] = candies[current - 1] + 1;
            }

            if (current < ratings.length - 1 && ratings[current + 1] < ratings[current]) {
                candies[current] = Math.max(candies[current], candies[current + 1] + 1);
            }

            total += candies[current];
        }

        return total;
    }

    private record Child(int rating, int index) {
    }
}
