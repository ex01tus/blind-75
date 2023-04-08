package string;

/**
 * Description: https://leetcode.com/problems/bulls-and-cows
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BullsAndCows {

    public String getHintWithTwoPasses(String secret, String guess) {
        int[] freqMap = buildFrequencyMap(secret);

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);

            if (secret.charAt(i) == guessChar) {
                bulls++;
                if (freqMap[guessChar - '0'] <= 0) cows--; // we've counted this char as a cow, but it is a bull
            } else if (freqMap[guessChar - '0'] > 0) {
                cows++;
            }

            freqMap[guessChar - '0']--;
        }

        return String.format("%dA%dB", bulls, cows);
    }

    private int[] buildFrequencyMap(String secret) {
        int[] freqMap = new int[10];
        for (char c : secret.toCharArray()) {
            freqMap[c - '0']++;
        }

        return freqMap;
    }

    public String getHintWithSinglePass(String secret, String guess) {
        int[] freqMap = new int[10];

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);

            if (secretChar == guessChar) {
                bulls++;
            } else {
                freqMap[secretChar - '0']++;
                freqMap[guessChar - '0']--;

                if (freqMap[secretChar - '0'] <= 0) cows++;
                if (freqMap[guessChar - '0'] >= 0) cows++;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
