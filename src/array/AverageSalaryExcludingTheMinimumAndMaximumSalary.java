package array;

/**
 * Description: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salaries) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int salary : salaries) {
            min = Math.min(min, salary);
            max = Math.max(max, salary);
            sum += salary;
        }

        return (double) (sum - min - max) / (salaries.length - 2);
    }
}
