/*
 * https://leetcode.com/problems/single-number/
 * O(n) time | O(1) space
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
