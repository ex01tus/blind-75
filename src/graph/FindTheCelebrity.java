package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-the-celebrity
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1) or O(n) with cache
 */
public class FindTheCelebrity {

    private final Map<Relation, Boolean> cache = new HashMap<>();

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int man = 1; man < n; man++) {
            if (cachedKnows(candidate, man)) {
                candidate = man;
            }
        }

        if (isCelebrity(candidate, n)) {
            return candidate;
        }

        return -1;
    }

    private boolean isCelebrity(int candidate, int n) {
        for (int man = 0; man < n; man++) {
            if (man == candidate) continue;
            if (cachedKnows(candidate, man) || !cachedKnows(man, candidate)) {
                return false;
            }
        }

        return true;
    }

    // use if API calls are expensive
    private boolean cachedKnows(int a, int b) {
        return cache.computeIfAbsent(new Relation(a, b), __ -> knows(a, b));
    }

    private record Relation(int a, int b) {
    }

    // API call
    private boolean knows(int a, int b) {
        return true;
    }
}
