import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/4sum/
 * O(n^3) time | O(1) space
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int start = j + 1, end = nums.length - 1;
                int sum = nums[i] + nums[j];

                while (start < end) {
                    List<Integer> list = new ArrayList<>();
                    if (nums[start] + nums[end] == target - sum) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);

                        result.add(list);

                        while (start < end && nums[start] == list.get(2))
                            start++;

                        while (end > start && nums[end] == list.get(3))
                            end--;
                    } else if (nums[start] + nums[end] < target - sum)
                        start++;
                    else
                        end--;
                }

                while (j < nums.length - 3 && nums[j] == nums[j + 1])
                    j++;
            }

            while (i < nums.length - 4 && nums[i] == nums[i + 1])
                i++;
        }

        return result;
    }
}
