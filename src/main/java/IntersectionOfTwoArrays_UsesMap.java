import java.util.*;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * O(m + n) time | O(m) space where m and n are sizes of input arrays and m < n
 */
public class IntersectionOfTwoArrays_UsesMap {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        int[] larger = nums1.length >= nums2.length ? nums1 : nums2;
        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;

        for (int item : smaller) {
            map.compute(item, (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int item : larger) {
            if (map.containsKey(item)) {
                result.add(item);

                int val = map.get(item);
                if (val == 1)
                    map.remove(item);
                else
                    map.put(item, val - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
