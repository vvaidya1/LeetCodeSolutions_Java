
/*
 * https://leetcode.com/problems/majority-element/
 * Boyer-Moore Voting Algorithm
 * O(n) time | O(1) space
 */
public class MajorityElement_Optimal {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;

            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
