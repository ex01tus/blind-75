package matrix;

/**
 * Description: https://leetcode.com/problems/flipping-an-image
 * Difficulty: Easy
 * Time complexity: O(n * n)
 * Space complexity: O(1)
 */
public class FlippingImage {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < (image[0].length + 1) / 2; col++) {
                int tmp = image[row][col];
                image[row][col] = image[row][image[0].length - 1 - col] ^ 1;
                image[row][image[0].length - 1 - col] = tmp ^ 1;
            }
        }

        return image;
    }
}
