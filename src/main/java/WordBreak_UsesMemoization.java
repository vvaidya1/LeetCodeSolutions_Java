import java.util.*;

/*
 * https://leetcode.com/problems/word-break/
 * O(n.n.n) time | O(n) space - time complexity n.n for actual algo and additional n for extracting substrings
 */
public class WordBreak_UsesMemoization {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return false;

        Set<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> memoize = new HashMap<>();
        return wordBreakHelper(s, set, memoize);
    }

    boolean wordBreakHelper(String s, Set<String> wordDict, Map<String, Boolean> memoize) {
        if (s.equals(""))
            return true;

        if (memoize.containsKey(s))
            return memoize.get(s);

        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreakHelper(s.substring(i), wordDict, memoize)) {
                memoize.put(s.substring(i), true);
                return true;
            }
        }
        memoize.put(s, false);
        return false;
    }
}

