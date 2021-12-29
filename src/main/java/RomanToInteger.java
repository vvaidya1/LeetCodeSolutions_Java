/*
 * https://leetcode.com/problems/roman-to-integer/
 * O(n) time | O(1) space where n is the length of input string
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int[] romanToInt = new int[26];
        romanToInt['I' - 'A'] = 1;
        romanToInt['V' - 'A'] = 5;
        romanToInt['X' - 'A'] = 10;
        romanToInt['L' - 'A'] = 50;
        romanToInt['C' - 'A'] = 100;
        romanToInt['D' - 'A'] = 500;
        romanToInt['M' - 'A'] = 1000;

        int prev = 'A', result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = romanToInt[s.charAt(i) - 'A'];
            result += currVal;

            if (romanToInt[prev - 'A'] < currVal) {
                result -= 2 * romanToInt[prev - 'A'];
            }
            prev = s.charAt(i);
        }
        return result;
    }
}
