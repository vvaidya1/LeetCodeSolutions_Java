import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  https://leetcode.com/problems/short-encoding-of-words/
 *  O(n.(m^2)) time | O(m.n) space - where n is the number of words and m is the average length of words
 */
public class ShortEncodingOfWords_UsesSet {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        Set<String> seen = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String str = word.substring(i);
                if (seen.contains(str))
                    seen.remove(str);
            }
        }

        int result = 0;
        for (String item : seen)
            result += item.length() + 1;

        return result;
    }
}
