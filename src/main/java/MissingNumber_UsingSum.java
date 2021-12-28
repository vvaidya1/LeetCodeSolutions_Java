/*
 * https://leetcode.com/problems/missing-number/
 * O(n) time | O(1) space
 */
public class MissingNumber_UsingSum {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
