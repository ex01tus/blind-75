package string;

/**
 * Description: https://leetcode.com/problems/read-n-characters-given-read4
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ReadNCharactersGivenReadN {

    public int read(char[] buf, int n) {
        int calls = n / 4 + (n % 4 == 0 ? 0 : 1);
        int pointer = 0;
        int charsLeft = n;

        char[] buf4 = new char[4];
        for (int call = 0; call < calls; call++) {
            int charsRead = Math.min(charsLeft, read4(buf4));
            charsLeft -= charsRead;
            for (int j = 0; j < charsRead; j++) {
                buf[pointer] = buf4[j];
                pointer++;
            }
        }

        return pointer;
    }

    // API call
    private int read4(char[] buf4) {
        return 4;
    }
}
