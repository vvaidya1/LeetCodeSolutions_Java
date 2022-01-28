
/*
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * O(n) time | O(n) space
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        s = cleanSpaces(s);
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int i = 0;
        while (i < arr.length) {
            int j = i;
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }

            reverse(arr, i, j - 1);
            i = j + 1;
        }
        return String.valueOf(arr);
    }

    void reverse(char[] arr, int i, int j) {
        while (i <= j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
    }

    String cleanSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0, l;
        while (k < s.length()) {
            l = k;
            while (l < s.length() && s.charAt(l) == ' ')
                l++;
            sb.append(s.charAt(k));
            k = (k == l) ? (k + 1) : l;
        }
        return sb.toString();
    }
}
