package interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/employee-free-time
 * Difficulty: Hard
 * Time complexity: O(nlog k)
 * Space complexity: O(k)
 */
public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<EmployeeInterval> minHeap = new PriorityQueue<>(this::compareIntervals);
        for (int i = 0; i < schedule.size(); i++) {
            Interval interval = schedule.get(i).get(0);
            // we can only store employee and index and get start and end from schedule
            minHeap.offer(new EmployeeInterval(interval.start, interval.end, i, 0));
        }

        int maxEnd = minHeap.peek().end;
        List<Interval> freeTime = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            EmployeeInterval current = minHeap.poll();

            if (current.start > maxEnd) {
                freeTime.add(new Interval(maxEnd, current.start));
            }

            maxEnd = Math.max(maxEnd, current.end);

            if (current.index + 1 < schedule.get(current.employee).size()) {
                Interval next = schedule.get(current.employee).get(current.index + 1);
                minHeap.offer(new EmployeeInterval(next.start, next.end, current.employee, current.index + 1));
            }
        }

        return freeTime;
    }

    private int compareIntervals(EmployeeInterval a, EmployeeInterval b) {
        int result = Integer.compare(a.start, b.start);
        if (result != 0) return result;
        return Integer.compare(a.end, b.end);
    }

    private record EmployeeInterval(int start, int end, int employee, int index) {
    }

    private record Interval(int start, int end) {
    }
}
