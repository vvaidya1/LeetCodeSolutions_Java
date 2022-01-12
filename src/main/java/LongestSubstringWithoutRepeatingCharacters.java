import java.util.*;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Set<Character> set = new HashSet<>();
        int start = 0, current = 0, end = s.length(), maxLength = 0;
        while (current < end) {
            if (!set.contains(s.charAt(current))) {
                set.add(s.charAt(current));
                maxLength = Math.max(maxLength, set.size());
                current++;
            }
            else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}