/*
 * https://leetcode.com/problems/sort-colors/
 * O(n) time | O(1) space
 */
public class SortColors_OnePass {
    public void sortColors(int[] nums) {
        int first = 0, second = 0, third = nums.length - 1;

        while (second <= third) {
            if (nums[second] == 0) {
                swap(nums, first, second);
                first++;
                second++;
            } else if (nums[second] == 2) {
                swap(nums, second, third);
                third--;
            } else
                second++;
        }
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
