package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/partition-labels
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();

        int[] lastIndices = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndices[chars[i] - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();

        int start = 0;
        int last = 0;
        for (int end = 0; end < chars.length; end++) {
            last = Math.max(last, lastIndices[chars[end] - 'a']);
            if (end == last) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }

        return partitions;
    }
}
