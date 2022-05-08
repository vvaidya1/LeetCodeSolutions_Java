/*
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 * O(1) time | O(1) space
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int previous = n & 1;
        n >>= 1;
        while (n > 0) {
            int current = n & 1;
            if (current == previous)
                return false;
            previous = current;
            n >>= 1;
        }
        return true;
    }
}
