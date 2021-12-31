import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/valid-sudoku/
 * O(1) time | O(1) space
 */
public class ValidSudoku_Clean {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;

                char ch = board[i][j];
                if (!seen.add("Seen " + ch + " in row" + i) ||
                        !seen.add("Seen " + ch + " in col" + j) ||
                        !seen.add("Seen " + ch + " in block" + (i / 3) * 3 + j / 3))
                    return false;
            }
        }
        return true;
    }
}
