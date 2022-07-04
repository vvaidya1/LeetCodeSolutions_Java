import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/
 * O(n) time | O(n) space - where n is the length of input array
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
        }

        int totalCandies = 0;
        for (int i = 0; i < ratings.length; i++)
            totalCandies += Math.max(left[i], right[i]);
        return totalCandies;
    }

}
