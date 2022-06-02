
/*
 * https://leetcode.com/problems/transpose-matrix/
 * O(m.n) time | O(m.n) space - where m and n are length and width of input matrix
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][0];

        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
