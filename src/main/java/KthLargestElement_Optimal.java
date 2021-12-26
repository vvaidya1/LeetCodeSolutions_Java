
/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * O(N) time average case, O(n^2) worst case - rare | O(1) space
 */
public class KthLargestElement_Optimal {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    void quickSelect(int[] nums, int k, int start, int end) {
        if (start >= end)
            return;

        int pivot = partition(nums, k, start, end);

        if (pivot == nums.length - k)
            return;
        else if (pivot < nums.length - k) {
            quickSelect(nums, k, pivot + 1, end);
        } else
            quickSelect(nums, k, start, pivot - 1);
    }

    int partition(int[] nums, int k, int start, int end) {
        int i = start;
        for (int j = i; j < end; j++) {
            if (nums[j] < nums[end]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
