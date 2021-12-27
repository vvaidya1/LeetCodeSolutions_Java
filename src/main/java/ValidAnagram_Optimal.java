import java.util.Arrays;

/*
 * https://leetcode.com/problems/valid-anagram/
 * O(n.log.n) time | O(n) space where n and m are lengths of input strings and n > m
 */
public class ValidAnagram_Optimal {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;
        else if (s.length() != t.length())
            return false;

        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            frequency[t.charAt(j) - 'a']--;

            if (frequency[t.charAt(j) - 'a'] < 0)
                return false;
        }

        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0)
                return false;
        }
        return true;
    }
}
