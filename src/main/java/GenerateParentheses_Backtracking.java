import java.util.*;

/*
 * https://leetcode.com/problems/generate-parentheses/
 * O(4^n / n.sqrt(n)) time - Catalan number | O(4^n / n.sqrt(n)) space
 */
public class GenerateParentheses_Backtracking {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(new StringBuilder(), 0, 0, 0, n, result);
        return result;
    }

    void backtracking(StringBuilder current, int pos, int open, int close, int max, List<String> result) {
        if (pos == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            backtracking(current, pos + 1, open + 1, close, max, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(")");
            backtracking(current, pos + 1, open, close + 1, max, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
