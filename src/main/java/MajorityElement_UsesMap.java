import java.util.*;

/*
 * https://leetcode.com/problems/majority-element/ *
 * O(n) time | O(n) space
 */
public class MajorityElement_UsesMap {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            int val = frequency.getOrDefault(num, 0) + 1;

            if (val > nums.length / 2)
                return num;

            frequency.put(num, val);
        }

        return -1;
    }
}
