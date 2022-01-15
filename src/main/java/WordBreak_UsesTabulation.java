import java.util.*;

/*
 * https://leetcode.com/problems/word-break/
 * O(n.n.n) time | O(n) space - time complexity n.n for actual algo and additional n for extracting substrings
 */
public class WordBreak_UsesTabulation {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return true;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < len; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, len)))
                    dp[len] = true;
            }
        }
        return dp[s.length()];
    }
}
