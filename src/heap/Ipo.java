package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/ipo
 * Difficulty: Hard
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class Ipo {

    public int findMaximizedCapital(int k, int currentCapital, int[] profits, int[] capital) {
        Project[] projects = toProjectSortedByCapitalAsc(profits, capital);

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int maxCapital = currentCapital;

        int current = 0;
        for (int i = 0; i < k; i++) {
            // add all the projects, that we can take based on our current capital
            while (current < projects.length && maxCapital >= projects[current].capital) {
                maxHeap.offer(projects[current].profit);
                current++;
            }

            // if no projects are available – we are done
            if (maxHeap.isEmpty()) break;

            // take the most profitable project
            maxCapital += maxHeap.poll();
        }

        return maxCapital;
    }

    private Project[] toProjectSortedByCapitalAsc(int[] profits, int[] capital) {
        Project[] projects = new Project[profits.length];
        for (int i = 0; i < profits.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, Comparator.comparingInt(a -> a.capital));

        return projects;
    }

    private record Project(int capital, int profit) {}
}
