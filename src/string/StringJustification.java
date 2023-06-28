package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/text-justification
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class StringJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justified = new ArrayList<>();

        List<String> currentLine = new ArrayList<>();
        int currentLineLength = 0;
        for (String word : words) {
            if (word.length() + currentLineLength + currentLine.size() <= maxWidth) {
                currentLine.add(word);
                currentLineLength += word.length();
            } else {
                justified.add(buildLine(currentLine, currentLineLength, false, maxWidth));
                currentLine = new ArrayList<>();
                currentLine.add(word);
                currentLineLength = word.length();
            }
        }

        justified.add(buildLine(currentLine, currentLineLength, true, maxWidth));

        return justified;
    }

    private String buildLine(List<String> words, int length, boolean isLastLine, int maxLength) {
        if (isLastLine || words.size() == 1) {
            return buildLeftJustifiedLine(words, length, maxLength);
        }

        return buildMidJustifiedLine(words, length, maxLength);
    }

    private String buildLeftJustifiedLine(List<String> words, int length, int maxLength) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i < words.size() - 1) line.append(" ");
        }

        int extraSpaces = maxLength - length - (words.size() - 1);
        for (int i = 0; i < extraSpaces; i++) {
            line.append(" ");
        }

        return line.toString();
    }

    private String buildMidJustifiedLine(List<String> words, int length, int maxLength) {
        int spaces = maxLength - length;
        int evenSpaces = spaces / (words.size() - 1);
        int extraSpaces = spaces % (words.size() - 1);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i == words.size() - 1) break;

            for (int j = 0; j < evenSpaces; j++) {
                line.append(" ");
            }

            if (extraSpaces > 0) {
                line.append(" ");
                extraSpaces--;
            }

        }

        return line.toString();
    }
}
