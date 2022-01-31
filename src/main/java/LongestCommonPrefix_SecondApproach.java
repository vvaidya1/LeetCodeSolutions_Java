
/*
 * https://leetcode.com/problems/longest-common-prefix/
 * O(n.k) time | O(1) space - where n is the length of string array and k is the length of smallest string
 */
public class LongestCommonPrefix_SecondApproach {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.length() == 0)
                    return prefix;
            }
        }
        return prefix;
    }
}
