
/*
 * https://leetcode.com/problems/repeated-string-match/
 * O(n * m) time | O(n) space
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0)
            return -1;

        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (checkSubstring(sb.toString(), b))
            return count;

        if (checkSubstring(sb.append(a).toString(), b))
            return count + 1;

        return -1;
    }

    boolean checkSubstring(String bigger, String smaller) {
        for (int i = 0; i < bigger.length() - smaller.length() + 1; i++) {
            int j;
            for (j = 0; j < smaller.length(); j++) {
                if (bigger.charAt(i + j) != smaller.charAt(j))
                    break;
            }

            if (j == smaller.length())
                return true;
        }
        return false;
    }
}
