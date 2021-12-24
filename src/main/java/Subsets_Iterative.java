import java.util.*;

/*
 * https://leetcode.com/problems/subsets/
 * O(n.2^n) time complexity | O(n.2^n) space complexity
 */
public class Subsets_Iterative {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(num);
                result.add(newList);
            }
        }
        return result;
    }
}
