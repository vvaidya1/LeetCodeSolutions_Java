/*
 * https://leetcode.com/problems/next-permutation/
 * O(n) time | O(1) space
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1)
            return;

        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i])
            i--;

        if (i > 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i-1])
                j--;
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end)
            swap(nums, start++, end--);
    }
}
