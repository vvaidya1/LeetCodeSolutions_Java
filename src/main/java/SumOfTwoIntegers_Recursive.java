/*
 * https://leetcode.com/problems/sum-of-two-integers/
 * O(1) time | O(1) complexity
 */
public class SumOfTwoIntegers_Recursive {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b) << 1);
    }
}
