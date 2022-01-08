
/*
 * https://leetcode.com/problems/set-matrix-zeroes/
 * O(m.n) time | O(1) space
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int m = matrix.length, n = matrix[0].length;
        boolean isFirstColZero = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) isFirstColZero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0)
                    matrix[0][j] = matrix[i][0] = 0;
            }
        }

        for (int i = m - 1; i>= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
            if (isFirstColZero) matrix[i][0] = 0;
        }
    }
}
