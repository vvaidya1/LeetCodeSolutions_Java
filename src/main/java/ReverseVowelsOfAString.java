import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * O(n) time | O(1) space
 */
public class ReverseVowelsOfAString {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] strArray = s.toCharArray();
        while (start < end) {
            if (isVowel(strArray[start]) && isVowel(strArray[end])) {
                swap(strArray, start, end);
                start++;
                end--;
            } else if (!isVowel(strArray[start])) start++;
            else end--;
        }
        return String.valueOf(strArray);
    }

    void swap(char[] strArray, int i, int j) {
        char ch = strArray[i];
        strArray[i] = strArray[j];
        strArray[j] = ch;
    }

    boolean isVowel(char ch) {
        return vowels.contains(ch);
    }
}
