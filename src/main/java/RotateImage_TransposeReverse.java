import Common.Cell;

/*
 * https://leetcode.com/problems/rotate-image/
 * O(m) time | O(1) - m is total number of cells in the matrix
 */
public class RotateImage_TransposeReverse {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Convert to a transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Cell a = new Cell(i, j);
                Cell b = new Cell(j, i);

                swap(matrix, a, b);
            }
        }

        //Reverse left to right
        for (int i = 0; i < n; i++) {
            for (int start = 0, end = n - 1; start < end; start++, end--) {
                Cell a = new Cell(i, start);
                Cell b = new Cell(i, end);

                swap(matrix, a, b);
            }
        }
    }

    void swap(int[][] matrix, Cell a, Cell b) {
        int temp = matrix[a.i][a.j];
        matrix[a.i][a.j] = matrix[b.i][b.j];
        matrix[b.i][b.j] = temp;
    }
}
