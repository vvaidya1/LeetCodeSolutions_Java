import java.util.*;

/*
 * https://leetcode.com/problems/maximum-erasure-value/
 * O(n) time | O(n) space - where n is the length of input array
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int result = 0;
        Map<Integer, Integer> tracker = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];
        for (int l = 0, r = 0; r < nums.length; r++) {
            prefixSum[r + 1] = prefixSum[r]+ nums[r];

            if (tracker.containsKey(nums[r]))
                l = Math.max(l, tracker.get(nums[r]) + 1);
            result = Math.max(result, prefixSum[r + 1] - prefixSum[l]);
            tracker.put(nums[r], r);
        }
        return result;
    }
}
