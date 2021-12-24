import java.util.*;

/*
 * https://leetcode.com/problems/subsets/
 * O(n.2^n) time complexity | O(n.2^n) space complexity
 */
public class Subsets_BackTracking {
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            backtracking(nums, i, 0, new ArrayList<>(), result);
        }
        return result;
    }

    void backtracking(int[] nums, int size, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int j = start; j < n; j++) {
            current.add(nums[j]);
            backtracking(nums, size, j + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
