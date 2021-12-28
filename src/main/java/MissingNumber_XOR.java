
/*
 * https://leetcode.com/problems/missing-number/
 * O(n) time | O(1) space
 */
public class MissingNumber_XOR {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i] ^ (i + 1);
        }
        return result;
    }
}
