import java.util.*;

/**
 * https://leetcode.com/problems/longest-string-chain/
 * O(n.log.n) + n.k.k time | O(n) space - where n is the number of words and k is the average length of all the words
 * O(n.log.n) - sorting and n.k.k - iterating over words into iterating over each character of a given word into deleting a char
 * Reference https://www.youtube.com/watch?v=pXG3uE_KqZM
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        for (String word : words) {
            map.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String newWord = sb.deleteCharAt(i).toString();
                if (map.containsKey(newWord) && map.get(newWord) + 1 > map.get(word))
                    map.put(word, map.get(newWord) + 1);

                res = Math.max(res, map.get(word));
            }
        }
        return res;
    }
}
