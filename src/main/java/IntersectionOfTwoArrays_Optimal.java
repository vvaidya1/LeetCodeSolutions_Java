import java.util.*;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * O(m + n) time | O(1) space where m and n are sizes of input arrays
 */
public class IntersectionOfTwoArrays_Optimal {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        int[] frequency = new int[1001];

        for (int item: nums1) {
            frequency[item]++;
        }

        int i = 0;
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        for (int item: nums2) {
            if (frequency[item] > 0) {
                result[i++] = item;
                frequency[item]--;
            }
        }
        return Arrays.copyOf(result, i);
    }
}
