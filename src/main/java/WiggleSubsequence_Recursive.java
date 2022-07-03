/**
 * https://leetcode.com/problems/wiggle-subsequence/
 * Throws TLE (Time Limit Exceeded)
 * O(n!) time | O(n) space - where n is the length of input array
 */
public class WiggleSubsequence_Recursive {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1 || (nums.length == 2 && nums[0] != nums[1]))
            return nums.length;

        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }

    int calculate(int[] nums, int index, boolean increasing) {
        int maxWiggle = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if ((increasing && nums[index] < nums[i]) || (!increasing && nums[index] > nums[i]))
                maxWiggle = Math.max(maxWiggle, 1 + calculate(nums, i, !increasing));
        }
        return maxWiggle;
    }
}
