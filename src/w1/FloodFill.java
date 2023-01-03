package w1;

/**
 * Description: https://leetcode.com/problems/flood-fill
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        recolor(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void recolor(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length) return;
        if (y < 0 || y >= image[0].length) return;
        if (image[x][y] != oldColor || image[x][y] == newColor) return;

        image[x][y] = newColor;

        recolor(image, x + 1, y, oldColor, newColor);
        recolor(image, x - 1, y, oldColor, newColor);
        recolor(image, x, y + 1, oldColor, newColor);
        recolor(image, x, y - 1, oldColor, newColor);
    }
}
