/*
 * https://leetcode.com/problems/reverse-bits/
 * O(1) time | O(1) space
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0)
            return 0;

        int result = 0;
        for (int i = 1; i <= 32; i++) {
            result = result << 1 | (n & 1);
            n >>= 1;
        }
        return result;
    }
}
