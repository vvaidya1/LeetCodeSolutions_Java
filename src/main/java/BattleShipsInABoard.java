/*
 * https://leetcode.com/problems/battleships-in-a-board/
 * O(m.n) time | O(1) space
 */
public class BattleShipsInABoard {
    public int countBattleships(char[][] board) {
        int result = 0;
        if (board == null || board.length == 0)
            return result;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    result++;
                    dfs(board, i, j);
                }
            }
        }
        return result;
    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.')
            return;

        board[i][j] = '.';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }
}
