package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/task-scheduler
 * Difficulty: Medium
 * Time complexity: O(nlog n) // O(n) for n = 26
 * Space complexity: O(n)     // O(1) for n = 26
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        Map<Character, Integer> frequencyMap = buildFrequencyMap(tasks);
        Queue<Task> tasksMaxHeap = initTasksMaxHeap(frequencyMap);
        Map<Integer, Task> taskCooldowns = new HashMap<>();

        int currentTime = 0;
        while (!tasksMaxHeap.isEmpty() || !taskCooldowns.isEmpty()) {
            int expiredCooldown = currentTime - n - 1;
            if (taskCooldowns.containsKey(expiredCooldown)) {
                Task readyForExecutionTask = taskCooldowns.remove(expiredCooldown);
                tasksMaxHeap.offer(readyForExecutionTask);
            }

            if (!tasksMaxHeap.isEmpty()) {
                Task currentTask = tasksMaxHeap.poll();
                System.out.println(currentTask.name);

                int executionsLeft = --currentTask.executionsLeft;

                if (executionsLeft > 0) {
                    taskCooldowns.put(currentTime, currentTask);
                }
            } else {
                System.out.println("[idle]");
            }

            currentTime++;
        }

        return currentTime;
    }

    private Map<Character, Integer> buildFrequencyMap(char[] tasks) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            frequencyMap.merge(task, 1, Integer::sum);
        }

        return frequencyMap;
    }

    private Queue<Task> initTasksMaxHeap(Map<Character, Integer> frequencyMap) {
        Queue<Task> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.executionsLeft, a.executionsLeft));
        for (Map.Entry<Character, Integer> task : frequencyMap.entrySet()) {
            maxHeap.offer(new Task(task.getKey(), task.getValue()));
        }

        return maxHeap;
    }

    private static class Task {

        private final char name;
        private int executionsLeft;

        public Task(char name, int executionsLeft) {
            this.name = name;
            this.executionsLeft = executionsLeft;
        }
    }

    public static void main(String[] args) {
        int time = new TaskScheduler()
                .leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
        System.out.println("\nTotal Time: " + time);
    }
}
