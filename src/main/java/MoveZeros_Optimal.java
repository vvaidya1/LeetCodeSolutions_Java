/*
 * https://leetcode.com/problems/move-zeroes/
 * O(n) time | O(1) space - performs less number of operations
 */
public class MoveZeros_Optimal {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
