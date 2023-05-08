package string;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/reorder-data-in-log-files
 * Difficulty: Medium
 * Time complexity: O(s * nlog n)
 * Space complexity: O(s * log n)
 */
public class ReorderDataInLogFiles {

    /**
     * Time complexity: O(s * nlog n)
     * Space complexity: O(s * log n)
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, this::compareLogs);
        return logs;
    }

    private int compareLogs(String log1, String log2) {
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);

        if (isDigitLog(split1[1]) && isDigitLog(split2[1])) return 0;
        if (isDigitLog(split1[1])) return 1;
        if (isDigitLog(split2[1])) return -1;

        int result = split1[1].compareTo(split2[1]);
        if (result != 0) return result;

        return split1[0].compareTo(split2[0]);
    }

    private boolean isDigitLog(String content) {
        return Character.isDigit(content.charAt(0));
    }
}
