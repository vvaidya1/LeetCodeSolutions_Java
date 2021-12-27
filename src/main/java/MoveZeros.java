/*
 * https://leetcode.com/problems/move-zeroes/
 * O(n) time | O(1) space
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            nums[i++] = nums[j++];
        }

        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
