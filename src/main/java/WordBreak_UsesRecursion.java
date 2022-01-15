import java.util.*;

/*
 * https://leetcode.com/problems/word-break/
 * O(2^n) time | O(n) space
 * Throws TLE (Time Limit Exceeded) exception on submission
 */
public class WordBreak_UsesRecursion {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return false;

        Set<String> set = new HashSet<>(wordDict);
        return wordBreakHelper(s, set);
    }

    boolean wordBreakHelper(String s, Set<String> wordDict) {
        if (s.isEmpty() || wordDict.contains(s))
            return true;

        for (int i = 0; i < s.length(); i++) {
            String word = (i == s.length() - 1) ? s.substring(i) : s.substring(0, i + 1);

            if (wordDict.contains(word) && wordBreakHelper(s.substring(i + 1), wordDict))
                return true;
        }
        return false;
    }
}
