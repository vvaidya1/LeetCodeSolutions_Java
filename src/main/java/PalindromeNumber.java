
/*
 * https://leetcode.com/problems/palindrome-number/
 * O(log.base10.n) time | O(1) space
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int originalNumber = x, reversedNumber = 0;
        while (x > 0) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x = x / 10;
        }
        return originalNumber == reversedNumber;
    }
}
