
/*
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * O(log.n) time | O(1) space
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == nums[mid^1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return nums[low];
    }
}
