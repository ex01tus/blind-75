package array;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/rank-transform-of-an-array
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class RankTransformOfArray {

    public int[] arrayRankTransformViaSorting(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int num : copy) {
            // rank is the number of elements, smaller than the current plus one
            rankMap.putIfAbsent(num, rankMap.size() + 1);
        }

        int[] ranks = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ranks[i] = rankMap.get(arr[i]);
        }

        return ranks;
    }

    public int[] arrayRankTransformViaTreeMap(int[] arr) {
        Map<Integer, List<Integer>> sortedMapOfIndices = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            sortedMapOfIndices.computeIfAbsent(arr[i], __ -> new ArrayList<>()).add(i);
        }

        int rank = 1;
        int[] ranks = new int[arr.length];
        for (List<Integer> indices : sortedMapOfIndices.values()) {
            for (int i : indices)  {
                ranks[i] = rank;
            }

            rank++;
        }

        return ranks;
    }
}
