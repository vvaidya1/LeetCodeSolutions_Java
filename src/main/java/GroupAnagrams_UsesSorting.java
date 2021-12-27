import java.util.*;

/*
 * https://leetcode.com/problems/group-anagrams/
 * O(n * m.lon.m) time | o(n) space - where n is number of input strings and m is average length of all words
 */
public class GroupAnagrams_UsesSorting {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            dict.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(dict.values());
    }
}
