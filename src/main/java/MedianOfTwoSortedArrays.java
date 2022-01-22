
/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * O(log.min(n, m)) time | O(1) space
 * Reference https://www.youtube.com/watch?v=LPFhl65R7ww
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = nums1.length;
        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (nums1.length + nums2.length + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == nums1.length) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == nums2.length) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / (double) 2;
                } else
                    return Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }
        return -1;
    }
}
