/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * O(n^2) time | O(1) space
 */
public class LongestPalindromicSubstring_Dp {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return null;

        if (s.length() == 1)
            return String.valueOf(s.charAt(0));

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;

        int start = 0, maxLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for (int k = 3; k <= s.length(); k++) {
            for (int i = 0; i < s.length() - k + 1; i++) {
                int j = i + k - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = k;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
