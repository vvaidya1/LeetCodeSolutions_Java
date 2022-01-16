import java.util.*;

/*
 * https://leetcode.com/problems/subsets-ii/
 * O(n.2^n) time | O(n.2^n) space
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int startIndex = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
            size = subsets.size();

            for (int j = startIndex; j < size; j++) {
                List<Integer> tempList = new ArrayList<>(subsets.get(j));
                tempList.add(nums[i]);
                subsets.add(tempList);
            }
        }
        return subsets;
    }
}
