package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/asteroid-collision
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop(); // asteroid goes left, destroying the ones going right
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // previous asteroid goes left or does not exist
                } else if (stack.peek() == -asteroid) {
                    stack.pop(); // destroy previous asteroid of the same size
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
