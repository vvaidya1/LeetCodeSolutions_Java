/*
 * https://leetcode.com/problems/unique-paths/
 * O(n+m) time | O(m+n) space
 */
public class UniquePahs_DP {
    public int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1)
                    uniquePaths[i][j] = 1;
                else {
                    int pathsUp = uniquePaths[i-1][j];
                    int pathsLeft = uniquePaths[i][j-1];
                    uniquePaths[i][j] = pathsUp + pathsLeft;
                }
            }
        }

        return uniquePaths[m][n];
    }
}
