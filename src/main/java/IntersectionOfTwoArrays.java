import java.util.*;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * O(n) time | O(n) space
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int item: nums1) {
            set.add(item);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int item: nums2) {
            if (set.contains(item)) {
                intersection.add(item);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
