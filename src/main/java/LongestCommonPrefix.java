/*
 * https://leetcode.com/problems/longest-common-prefix/
 * O(n.k) time | O(1) space - where n is the length of string array and k is the length of smallest string
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return result.toString();
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}
