/*
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 * O(n) time | O(1) space - where n is the length of the input string
 */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0)
            return 0;

        return isPalindrome(s) ? 1 : 2;
    }

    boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
