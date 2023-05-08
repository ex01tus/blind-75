package math;

/**
 * Description: https://leetcode.com/problems/day-of-the-week
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class DayOfTheWeek {

    private static final int EPOCH_YEAR = 1971;

    public String dayOfTheWeek(int day, int month, int year) {
        // 1971-01-01 was a Friday
        String[] weekDays = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        int epochDay = 0;
        for (int y = EPOCH_YEAR; y < year; y++) {
            epochDay += isLeapYear(y) ? 366 : 365;
        }

        // during the leap year February has 29 days
        int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysPerMonth[1] = 29;
        for (int m = 0; m < month - 1; m++) {
            epochDay += daysPerMonth[m];
        }

        // zero indexed
        epochDay += day - 1;
        return weekDays[epochDay % weekDays.length];
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}
