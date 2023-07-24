package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/reward-top-k-students
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class RewardTopKStudents {

    public List<Integer> topStudents(
            String[] positiveFeedback,
            String[] negativeFeedback,
            String[] reports,
            int[] studentIds,
            int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positiveFeedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negativeFeedback));
        Queue<Student> maxHeap = buildHeap(studentIds, reports, positive, negative);

        return getTopK(maxHeap, k);
    }

    private List<Integer> getTopK(Queue<Student> maxHeap, int k) {
        List<Integer> topK = new ArrayList<>();
        while (k > 0) {
            topK.add(maxHeap.poll().id);
            k--;
        }

        return topK;
    }

    private Queue<Student> buildHeap(
            int[] studentIds,
            String[] reports,
            Set<String> positive,
            Set<String> negative) {
        Queue<Student> maxHeap = new PriorityQueue<>(
                Comparator.comparing(Student::points).reversed().thenComparing(Student::id));

        for (int i = 0; i < studentIds.length; i++) {
            int points = countPoints(reports[i], positive, negative);
            maxHeap.offer(new Student(studentIds[i], points));
        }

        return maxHeap;
    }

    private int countPoints(String report, Set<String> positive, Set<String> negative) {
        String[] words = report.split(" ");

        int points = 0;
        for (String word : words) {
            if (positive.contains(word)) {
                points += 3;
            } else if (negative.contains(word)) {
                points -= 1;
            }
        }

        return points;
    }

    private record Student(int id, int points) {
    }
}
