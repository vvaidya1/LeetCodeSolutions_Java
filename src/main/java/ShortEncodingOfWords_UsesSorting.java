import java.util.Arrays;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 * O(m.n.log.n) time | O(m.n) space - where n is the number of words and m is the average length of words
 * Less intuitive - not recommended for interviews - accepted though
 */
public class ShortEncodingOfWords_UsesSorting {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.indexOf(word + "#") == -1) {
                sb.append(word);
                sb.append("#");
            }
        }
        return sb.length();
    }
}
