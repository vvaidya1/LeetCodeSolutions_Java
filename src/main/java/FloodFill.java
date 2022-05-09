/*
 * https://leetcode.com/problems/flood-fill/
 * O(m.n) time | O(1) space where m = number of rows and n = number of columns
 */
public class FloodFill {
    int[] delta = {0, -1, 0, 1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;
        for (int i = 1; i < delta.length; i++) {
            fill(image, sr + delta[i - 1], sc + delta[i], color, newColor);
        }
    }
}
