package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/longest-absolute-file-path
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        int max = 0;
        for (String dir : input.split("\n")) {
            int tabsNumber = dir.lastIndexOf("\t") + 1;

            // return back to parent dir
            while (tabsNumber < stack.size() - 1) {
                stack.pop();
            }

            // parent + currentDir - "\t" * tabsNumber + "/"
            int pathLength = stack.peek() + dir.length() - tabsNumber + 1;
            stack.push(pathLength);

            // file found -> remove last "/"
            if (dir.contains(".")) {
                max = Math.max(max, pathLength - 1);
            }
        }

        return max;
    }
}
