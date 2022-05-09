/*
 * https://leetcode.com/problems/flipping-an-image/
 * O(m.n) time | O(1) space where m = number of rows and n = number of columns
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        if (image == null || image.length == 0)
            return image;

        for (int i = 0; i < image.length; i++) {
            int start = 0, end = image[i].length - 1;
            while (start < end) {
                int temp = image[i][start];
                image[i][start++] = image[i][end];
                image[i][end--] = temp;
            }

            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
