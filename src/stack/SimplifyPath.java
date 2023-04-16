package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/simplify-path
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] dirs = path.split("/"); // can use "/+" regex

        Deque<String> stack = new LinkedList<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast()); // get elements from the deque tail
//            result.insert(0, stack.pop()).insert(0, "/");
        }

        return result.isEmpty() ? "/" : result.toString();
    }
}
