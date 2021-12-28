
/*
 * https://leetcode.com/problems/number-of-1-bits/
 * O(1) time | O(1) space
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
