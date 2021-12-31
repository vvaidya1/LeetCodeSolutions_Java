import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/valid-sudoku/
 * O(1) time | O(1) space
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> col = new ArrayList<>();
        List<Set<Character>> matrix = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            matrix.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;

                int matrixIndex = (i / 3) * 3 + j / 3;
                if (row.get(i).contains(board[i][j]) ||
                        col.get(j).contains(board[i][j]) ||
                        matrix.get(matrixIndex).contains(board[i][j])) {
                    return false;
                } else {
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    matrix.get(matrixIndex).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
