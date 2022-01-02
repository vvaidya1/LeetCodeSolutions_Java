/*
 * https://leetcode.com/problems/maximum-subarray/
 * O(n) time | O(1) space
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int currentSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] < nums[i])
                currentSum = nums[i];
            else
                currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
