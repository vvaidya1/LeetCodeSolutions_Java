/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * O(n) time | O(1) space
 */
public class FirstUniqueCharInAString_Optimal {
    public int firstUniqChar(String s) {
        int ans = s.length();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                ans = Math.min(ans, index);
            }
        }
        return ans == s.length() ? -1 : ans;
    }
}
