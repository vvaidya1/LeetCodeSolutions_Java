import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/4sum-ii/
 * O(n^2) time | O(n^2) space
 */
public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        Map<Integer, Integer> sum = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                sum.put(a + b, sum.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                count += sum.getOrDefault(-(c + d), 0);
            }
        }

        return count;
    }
}
