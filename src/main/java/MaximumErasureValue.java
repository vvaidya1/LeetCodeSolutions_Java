import java.util.*;

/*
 * https://leetcode.com/problems/maximum-erasure-value/
 * O(n) time | O(n) space - where n is the length of input array
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] prefixSum = new int[nums.length + 1];
        Map<Integer, Integer> tracker = new HashMap<>();
        int result = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            prefixSum[right + 1] = prefixSum[right] + nums[right];

            if (tracker.containsKey(nums[right]))
                left = Math.max(left, tracker.get(nums[right]) + 1);

            result = Math.max(result, prefixSum[right + 1] - prefixSum[left]);
            tracker.put(nums[right], right);
        }
        return result;
    }
}
