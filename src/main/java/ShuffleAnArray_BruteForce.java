import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * https://leetcode.com/problems/shuffle-an-array/
 * O(n^2) time | O(n) space
 */
public class ShuffleAnArray_BruteForce {
    int[] clone;
    int[] original;

    public ShuffleAnArray_BruteForce(int[] nums) {
        clone = nums;
        original = nums.clone();
    }

    public int[] reset() {
        clone = original;
        original = original.clone();
        return clone;
    }

    public int[] shuffle() {
        Random random = new Random();
        List<Integer> aux = getAuxiliaryList();
        for (int i = 0; i < clone.length; i++) {
            int index = random.nextInt(aux.size());
            clone[i] = aux.get(index);
            aux.remove(index);
        }

        return clone;
    }

    List<Integer> getAuxiliaryList() {
        List<Integer> aux = new ArrayList<>();
        for (int element : original) {
            aux.add(element);
        }
        return aux;
    }
}
