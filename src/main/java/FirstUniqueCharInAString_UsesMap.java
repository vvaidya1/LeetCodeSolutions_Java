import java.util.*;

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * O(n) time | O(1) space
 */
public class FirstUniqueCharInAString_UsesMap {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty())
            return -1;

        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(array[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
