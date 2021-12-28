/*
 * https://leetcode.com/problems/unique-paths/
 * O(n+m) time | O(m+n) space
 */
public class UniquePaths_DP {
    public int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m][n];
        uniquePaths[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0)
                    uniquePaths[i][j] += uniquePaths[i-1][j];

                if (j - 1 >= 0)
                    uniquePaths[i][j] += uniquePaths[i][j-1];
            }
        }

        return uniquePaths[m-1][n-1];
    }
}
