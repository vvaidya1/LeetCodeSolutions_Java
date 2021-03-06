/*
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * O(1) time | O(m.n) space - where m and n are number of rows and columns of the input matrix
 */
public class RangeSumQuery2DImmutable {
    int[][] dp;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
