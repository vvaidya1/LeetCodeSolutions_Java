/*
 * https://leetcode.com/problems/excel-sheet-column-number/
 * O(n) time | O(1) space where n is the length of input string
 */
public class ExcelColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            result += (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
