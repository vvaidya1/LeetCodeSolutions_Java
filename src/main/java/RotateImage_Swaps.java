import Common.Cell;

/*
 * https://leetcode.com/problems/rotate-image/
 * O(m) time | O(1) - m is total number of cells in the matrix
 */
public class RotateImage_Swaps {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                Cell a = new Cell(i, j);
                swap(matrix, a, new Cell(j, n - 1 - i));
                swap(matrix, a, new Cell(n - 1 - i, n - 1 -j));
                swap(matrix, a, new Cell(n - 1 - j, i));
            }
        }
    }

    void swap(int[][] matrix, Cell a, Cell b) {
        int temp = matrix[a.i][a.j];
        matrix[a.i][a.j] = matrix[b.i][b.j];
        matrix[b.i][b.j] = temp;
    }
}
