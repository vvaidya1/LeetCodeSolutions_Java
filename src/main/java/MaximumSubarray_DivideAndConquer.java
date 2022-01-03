/*
 * https://leetcode.com/problems/maximum-subarray/
 * O(n.log.n) time | O(1) space
 */
public class MaximumSubarray_DivideAndConquer {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    int maxSubArrayHelper(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];

        int mid = start + (end - start) / 2;

        int leftSum = maxSubArrayHelper(nums, start, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, end);

        return Math.max(Math.max(leftSum, rightSum), crossingSum(nums, start, mid, end));
    }

    int crossingSum(int[] nums, int start, int mid, int end) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

        for (int i = mid; i >= start; i--) {
            sum += nums[i];
            leftSum = Math.max(sum, leftSum);
        }

        sum = 0;
        for (int j = mid + 1; j <= end; j++) {
            sum += nums[j];
            rightSum = Math.max(sum, rightSum);
        }
        return leftSum + rightSum;
    }
}
