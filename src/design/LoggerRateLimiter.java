package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/logger-rate-limiter
 * Difficulty: Easy
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class LoggerRateLimiter {

    private static final int RATE_LIMIT_INTERVAL_SEC = 10;

    private static class Logger {

        private final Map<String, Integer> lastPrinted;

        public Logger() {
            this.lastPrinted = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (lastPrinted.getOrDefault(message, -RATE_LIMIT_INTERVAL_SEC) + RATE_LIMIT_INTERVAL_SEC <= timestamp) {
                lastPrinted.put(message, timestamp);
                return true;
            }

            return false;
        }
    }
}
