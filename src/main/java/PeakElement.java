/*
 * https://leetcode.com/problems/find-peak-element/
 * O(log.n) time | O(1) space
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
