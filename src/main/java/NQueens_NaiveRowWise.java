import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/n-queens/
 * O(n^3) time | O(n^2) space
 * Reference https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=58
 * Start placing row wise
 */
public class NQueens_NaiveRowWise {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0)
            return result;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        solve(board, 0, result);
        return result;
    }

    void solve(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board)
                list.add(String.valueOf(chars));
            result.add(list);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (row + col == i + j || row - col == i - j || j == col))
                    return false;
            }
        }
        return true;
    }
}
