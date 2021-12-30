import java.util.*;

/*
 * https://leetcode.com/problems/shuffle-an-array/
 * O(n) time | O(n) space
 */
public class ShuffleAnArray_Optimal {
    int[] clone;
    int[] original;

    public ShuffleAnArray_Optimal(int[] nums) {
        clone = nums;
        original = nums.clone();
    }

    public int[] reset() {
        clone = original;
        original = original.clone();
        return clone;
    }

    public int[] shuffle() {
        for (int i = 0; i < clone.length; i++) {
            int index = getRandomIndex(i, clone.length);
            swap(i, index);
        }
        return clone;
    }

    int getRandomIndex(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    void swap(int i, int j) {
        int temp = clone[i];
        clone[i] = clone[j];
        clone[j] = temp;
    }
}
