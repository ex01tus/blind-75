package matrix;

/**
 * Description: https://leetcode.com/problems/lonely-pixel-i
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n + m)
 */
public class LonelyPixel {

    public int findLonelyPixel(char[][] picture) {
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] != 'B') continue;

                rows[i]++;
                cols[j]++;
            }
        }

        int lonely = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    lonely++;
                }
            }
        }

        return lonely;
    }
}
