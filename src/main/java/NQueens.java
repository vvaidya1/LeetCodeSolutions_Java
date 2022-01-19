import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/n-queens/
 * O(n^3) time | O(n^2) space
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0, result);
        return result;
    }

    void solve(char[][] board, int i, List<List<String>> result) {
        if (i == board.length) {
            List<String> newBoard = new ArrayList<>();
            for (char[] chars : board) {
                String str = String.valueOf(chars);
                newBoard.add(str);
            }
            result.add(newBoard);
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (isSafe(board, j, i)) {
                board[j][i] = 'Q';
                solve(board, i + 1, result);
                board[j][i] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col) {
        int i = row, j = col;

        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q')
                return false;
        }

        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j--] == 'Q')
                return false;
        }

        i = row;
        j = col;
        while (i < board.length && j >= 0) {
            if (board[i++][j--] == 'Q')
                return false;
        }
        return true;
    }

}
