/*
 * https://leetcode.com/problems/sort-colors/
 * O(n) time | O(1) space
 */
public class SortColors_TwoPass {
    public void sortColors(int[] nums) {
        int first = 0, second = 0, third = nums.length - 1;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, index);
                index++;
            }
        }

        index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                swap(nums, i, index);
                index--;
            }
        }

    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
