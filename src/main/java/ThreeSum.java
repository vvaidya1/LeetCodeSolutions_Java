import java.util.*;

/*
 * https://leetcode.com/problems/3sum/
 * O(n^2) time | O(1) space
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            int target = 0 - nums[i];

            while (start < end) {
                List<Integer> temp = new ArrayList<>();
                if (nums[start] + nums[end] == target) {
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    resultSet.add(temp);

                    while (start < end && nums[start] == temp.get(1))
                        start++;

                    while (start < end && nums[end] == temp.get(2))
                        end--;
                } else if (nums[start] + nums[end] < target)
                    start++;
                else
                    end--;
            }

            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        result.addAll(resultSet);
        return result;
    }
}
