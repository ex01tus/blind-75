package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/palindrome-pairs
 * Difficulty: Hard
 */
public class PalindromePairs {

    /**
     * Time complexity: O(n^2 * length)
     * Space complexity: O(n^2 + length)
     */
    public List<List<Integer>> palindromePairsViaBruteForce(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(words[i] + words[j])) {
                    pairs.add(List.of(i, j));
                }
            }
        }

        return pairs;
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    /**
     * Time complexity: O(n * length^2)
     * Space complexity: O(n^2 + length^2)
     */
    public List<List<Integer>> palindromePairsViaPrefixesAndSuffixes(String[] words) {
        Map<String, Integer> wordToIndexMap = toMap(words);

        List<List<Integer>> pairs = new ArrayList<>();
        for (String word : words) {
            List<Integer> reversedWordPairs = findReversedWordPairs(word, wordToIndexMap);           // [abc] + [cba]
            List<List<Integer>> reversedPrefixPairs = findReversedPrefixPairs(word, wordToIndexMap); // [abc]aba + [cba]
            List<List<Integer>> reversedSuffixPairs = findReversedSuffixPairs(word, wordToIndexMap); // [cba] + aba[abc]

            pairs.add(reversedWordPairs);
            pairs.addAll(reversedPrefixPairs);
            pairs.addAll(reversedSuffixPairs);
        }

        return pairs.stream().filter(l -> !l.isEmpty()).toList();
    }

    private List<Integer> findReversedWordPairs(String word, Map<String, Integer> wordToIndexMap) {
        String reversed = new StringBuilder(word).reverse().toString();
        int currentIndex = wordToIndexMap.get(word);
        return wordToIndexMap.containsKey(reversed) && currentIndex != wordToIndexMap.get(reversed)
                ? List.of(currentIndex, wordToIndexMap.get(reversed))
                : List.of();
    }

    private List<List<Integer>> findReversedSuffixPairs(String word, Map<String, Integer> wordToIndexMap) {
        List<String> suffixes = getAllValidSuffixes(word);

        List<List<Integer>> pairs = new ArrayList<>();
        int currentIndex = wordToIndexMap.get(word);
        for (String suffix : suffixes) {
            String reversed = new StringBuilder(suffix).reverse().toString();
            if (wordToIndexMap.containsKey(reversed)) {
                pairs.add(List.of(wordToIndexMap.get(reversed), currentIndex));
            }
        }

        return pairs;
    }

    private List<String> getAllValidSuffixes(String word) {
        List<String> suffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0 , i)) {
                suffixes.add(word.substring(i + 1));
            }
        }

        return suffixes;
    }

    private List<List<Integer>> findReversedPrefixPairs(String word, Map<String, Integer> wordToIndexMap) {
        List<String> prefixes = getAllValidPrefixes(word);

        List<List<Integer>> pairs = new ArrayList<>();
        int currentIndex = wordToIndexMap.get(word);
        for (String prefix : prefixes) {
            String reversed = new StringBuilder(prefix).reverse().toString();
            if (wordToIndexMap.containsKey(reversed)) {
                pairs.add(List.of(currentIndex, wordToIndexMap.get(reversed)));
            }
        }

        return pairs;
    }

    private List<String> getAllValidPrefixes(String word) {
        List<String> prefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, i, word.length() - 1)) {
                prefixes.add(word.substring(0, i));
            }
        }

        return prefixes;
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    private Map<String, Integer> toMap(String[] words) {
        Map<String, Integer> wordToIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordToIndexMap.put(words[i], i);
        }

        return wordToIndexMap;
    }
}
