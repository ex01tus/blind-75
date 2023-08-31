package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupToPeople = new HashMap<>();

        List<List<Integer>> groups = new ArrayList<>();
        for (int person = 0; person < groupSizes.length; person++) {
            int groupSize = groupSizes[person];
            List<Integer> group = groupToPeople.computeIfAbsent(groupSize, __ -> new ArrayList<>());
            group.add(person);

            if (group.size() == groupSize) {
                groups.add(group);
                groupToPeople.remove(groupSize);
            }

        }

        return groups;
    }
}
