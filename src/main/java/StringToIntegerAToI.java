/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 * O(n) time | O(1) space
 */
public class StringToIntegerAToI {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1, result = 0;

        int i = 0, start = 0, end = 0;
        while (i < s.length()) {
            if (i == 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
                sign = s.charAt(0) == '-' ? -1 : 1;
            } else if (Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';

                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                result = result * 10 + digit;
            } else
                break;
            i++;
        }
        return sign * result;
    }
}
