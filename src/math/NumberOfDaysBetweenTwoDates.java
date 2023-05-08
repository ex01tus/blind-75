package math;

/**
 * Description: https://leetcode.com/problems/number-of-days-between-two-dates
 * Difficulty: Easy
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 */
public class NumberOfDaysBetweenTwoDates {

    private static final int EPOCH_YEAR = 1971;

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFromEpoch(date1) - daysFromEpoch(date2));
    }

    private int daysFromEpoch(String date) {
        String[] tokens = date.split("-");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]) - 1;
        int day = Integer.parseInt(tokens[2]);

        int days = 0;
        for (int y = EPOCH_YEAR; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysPerMonth[1] = 29;
        for (int m = 0; m < month; m++) {
            days += daysPerMonth[m];
        }

        return days + day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}
