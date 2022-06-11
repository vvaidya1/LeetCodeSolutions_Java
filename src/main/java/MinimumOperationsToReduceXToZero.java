import java.util.*;

/*
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * O(n) time | O(n) space - where n is the length of the input array
 */
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        if (nums == null || nums.length == 0)
            return -1;

        int target = 0, sum = 0, len = Integer.MIN_VALUE;
        for (int num : nums) target += num;
        target -= x;

        if (target == 0)
            return nums.length;

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (prefixSum.containsKey(sum - target))
                len = Math.max(len, i - prefixSum.get(sum - target));

            prefixSum.put(sum, i);
        }

        return len == Integer.MIN_VALUE ? -1 : nums.length - len;
    }
}
