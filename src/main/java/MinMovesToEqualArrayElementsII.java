import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * O(n.log.n) time | O(1) space - where n is the length of input array
 * Reference https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2215782/Visual-Explanation-%2B-Interview-Tips-or-JAVA
 */
public class MinMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int median = nums[nums.length / 2], result = 0;
        for (int item : nums)
            result += Math.abs(item - median);

        return result;
    }
}
