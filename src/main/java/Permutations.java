import java.util.*;
import java.util.stream.*;

/*
 * https://leetcode.com/problems/permutations/
 * O(n.n!) time complexity | O(n.n!) space complexity
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }

    void permuteHelper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length)
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permuteHelper(nums, i + 1, result);
                swap(nums, i, j);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
