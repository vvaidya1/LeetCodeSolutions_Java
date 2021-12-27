/*
 * https://leetcode.com/problems/game-of-life/
 * O(r.c) time | O(1) space where r = number of rows and c = number of columns
 */
public class GameOfLife_InPlace {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighborsLive = getNumOfLiveNeighbors(board, i, j);

                if(board[i][j] == 1 && (neighborsLive >= 2 && neighborsLive <= 3)) board[i][j] = 3;
                if(board[i][j] == 0 && (neighborsLive == 3)) board[i][j] = 2;
            }
        }

        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[0].length; l++) {
                board[k][l] >>= 1;
            }
        }
    }

    int getNumOfLiveNeighbors(int[][] board, int i, int j) {
        int liveNeighbors = 0;
        for (int r = Math.max(i-1, 0); r <= Math.min(i+1, board.length-1); r++) {
            for (int c = Math.max(j-1, 0); c <= Math.min(j+1, board[0].length-1); c++) {
                liveNeighbors += board[r][c] & 1;
            }
        }
        liveNeighbors -= board[i][j] & 1;
        return liveNeighbors;
    }
}
