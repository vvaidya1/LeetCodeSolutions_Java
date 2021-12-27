import java.util.*;

/*
 * https://leetcode.com/problems/group-anagrams/
 * O(n * m) time | o(n) space - where n is number of input strings and m is average length of all words
 */
public class Group_Anagrams_Optimal {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            char[] frequency = new char[26];
            for (char ch : charArray) {
                frequency[ch - 'a']++;
            }

            String key = new String(frequency);
            dict.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(dict.values());
    }
}
