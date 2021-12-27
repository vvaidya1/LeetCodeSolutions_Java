import java.util.Arrays;

/*
 * https://leetcode.com/problems/valid-anagram/
 * O(n.log.n) time | O(n) space where n and m are lengths of input strings and n > m
 */
public class ValidAnagramUsesSorting {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        String newS = new String(sArray);
        String newT = new String(tArray);

        return newS.equals(newT);
    }
}
