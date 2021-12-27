/*
 * https://leetcode.com/problems/game-of-life/
 * O(r.c) time | O(r.c) space where r = number of rows and c = number of columns
 */
public class GameOfLife_BruteForce {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighborsLive = getNumOfLiveNeighbors(board, i, j);

                if (board[i][j] == 1 && neighborsLive < 2)
                    newBoard[i][j] = 0;
                else if (board[i][j] == 1 && (neighborsLive == 2 || neighborsLive == 3))
                    newBoard[i][j] = 1;
                else if (board[i][j] == 1 && neighborsLive > 3)
                    newBoard[i][j] = 0;
                else if (board[i][j] == 0 && neighborsLive == 3)
                    newBoard[i][j] = 1;
                else
                    newBoard[i][j] = 0;
            }
        }

        for (int k = 0; k < board.length; k++) {
            System.arraycopy(newBoard[k], 0, board[k], 0, board[0].length);
        }
    }

    int getNumOfLiveNeighbors(int[][] board, int i, int j) {
        int liveNeighbors = 0;
        for (int r = Math.max(i - 1, 0); r <= Math.min(i + 1, board.length - 1); r++) {
            for (int c = Math.max(j - 1, 0); c <= Math.min(j + 1, board[0].length - 1); c++) {
                liveNeighbors += board[r][c] & 1;
            }
        }
        liveNeighbors -= board[i][j] & 1;
        return liveNeighbors;
    }
}

