/*
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * O(n) time | O(1) space - where n is the length of input array
 */
public class RunningSum {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int i = 0;
        int[] result = new int[nums.length];
        for (int item : nums) {
            result[i] = (i == 0) ? item : result[i - 1] + item;
            i++;
        }
        return result;
    }
}
