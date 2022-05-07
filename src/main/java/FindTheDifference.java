/*
 * https://leetcode.com/problems/find-the-difference/
 * O(n) time | O(1) space
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] seen = new int[26];
        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i) - 'a']++;
            seen[t.charAt(i) - 'a']--;
        }
        seen[t.charAt(s.length()) - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (seen[i] != 0) {
                return (char) (i + 'a');
            }
        }

        return '!';
    }
}
