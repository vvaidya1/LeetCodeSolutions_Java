/**
 * https://leetcode.com/problems/wiggle-subsequence/
 * O(n) time | O(1) space
 */
public class WiggleSubsequence_Greedy {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1 || (nums.length == 2 && nums[0] != nums[1]))
            return nums.length;

        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((prevDiff >= 0 && diff < 0) || (prevDiff <= 0 && diff > 0)) {
                count++;
                prevDiff = diff;
            }
        }
        return count;
    }
}
