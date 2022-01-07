
/*
 * https://leetcode.com/problems/remove-element/
 * O(n) time | O(n) space where n is number of elements in the input array
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length, index = 0;
        while (start < end) {
            if (nums[start] == val) {
                nums[start] = nums[end - 1];
                end--;
            }
            else {
                start++;
            }
        }
        return end;
    }
}
