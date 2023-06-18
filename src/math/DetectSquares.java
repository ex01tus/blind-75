package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/detect-squares
 * Difficulty: Medium
 * Time complexity: O(1) for add(), O(n) for count()
 * Space complexity: O(n)
 */
public class DetectSquares {

    private static class CustomDetectSquares {

        private final Map<Point, Integer> points;

        public CustomDetectSquares() {
            this.points = new HashMap<>();
        }

        public void add(int[] point) {
            points.merge(new Point(point[0], point[1]), 1, Integer::sum);
        }

        public int count(int[] point) {
            int count = 0;
            for (Point p : points.keySet()) {
                // find points that form a square diagonal with the query point
                if (Math.abs(point[0] - p.x) != Math.abs(point[1] - p.y)
                        // skip zero area squares
                        || point[0] == p.x
                        || point[1] == p.y) {
                    continue;
                }

                count += points.get(p)                                                 // diagonal point
                        * points.getOrDefault(new Point(p.x, point[1]), 0)  // top left point
                        * points.getOrDefault(new Point(point[0], p.y), 0); // bottom right
            }

            return count;
        }

        private record Point(int x, int y) {
        }
    }
}
